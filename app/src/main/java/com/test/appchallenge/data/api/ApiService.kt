package com.test.appchallenge.data.api

import com.test.appchallenge.data.model.Giphy
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        private const val PAGE_QUERY_PARAM = "page"
        private const val SIZE_QUERY_PARAM = "limit"
        private const val TRENDING_URL = "trending"
    }

    @GET(TRENDING_URL)
    suspend fun getTrendingGif(
        @Query(PAGE_QUERY_PARAM) page: Int,
        @Query(SIZE_QUERY_PARAM) offset: Int
    ): Response<Giphy>

}