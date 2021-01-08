package com.test.appchallenge.data

import androidx.paging.DataSource
import com.test.appchallenge.data.api.ApiService
import com.test.appchallenge.data.model.Data

class GiphyDataSourceFactory(api: ApiService) : DataSource.Factory<Int, Data>() {

    private val source = GiphyDataSource(api)

    override fun create(): DataSource<Int, Data> {
        return source
    }
}