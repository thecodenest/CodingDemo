package com.test.appchallenge.data

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.test.appchallenge.data.api.ApiService
import com.test.appchallenge.data.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class GiphyDataSource(private val api: ApiService) : PageKeyedDataSource<Int, Data>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Data>
    ) {

        callAPI(1, params.requestedLoadSize) { repos, next ->
            callback.onResult(repos, null, next)
        }


    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Data>) {
        callAPI(params.key, params.requestedLoadSize) { repos, next ->
            callback.onResult(repos, next)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Data>) {
        TODO("Not yet implemented")
    }

    private fun callAPI(
        page: Int,
        perPage: Int,
        callback: (repos: List<Data>, next: Int?) -> Unit
    ) {


        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getTrendingGif(page, perPage)
                response.body()?.data?.let {
                    var next: Int? = null
                    if (response.body() != null) {
                        next = page + 1
                    }
                    callback(it, next)
                }

            } catch (e: IOException) {
                Log.d("test", e.message.toString())
            }
        }
    }

}