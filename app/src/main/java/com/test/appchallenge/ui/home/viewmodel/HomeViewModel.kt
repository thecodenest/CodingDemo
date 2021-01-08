package com.test.appchallenge.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.test.appchallenge.data.GiphyDataSourceFactory
import com.test.appchallenge.data.api.RetrofitBuilder
import com.test.appchallenge.data.model.Data

class HomeViewModel :
    ViewModel() {

    companion object {
        private const val PAGE_SIZE = 25
        private const val LOAD_INITIAL = 10
    }

    val repos: LiveData<PagedList<Data>>

    init {
        val factory = GiphyDataSourceFactory(RetrofitBuilder.apiService)
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(LOAD_INITIAL)
            .setPageSize(PAGE_SIZE)
            .build()

        repos = LivePagedListBuilder(factory, config).build()

    }

}