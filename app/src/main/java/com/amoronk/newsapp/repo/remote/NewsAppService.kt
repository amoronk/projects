package com.amoronk.newsapp.repo.remote

import com.amoronk.newsapp.data.NewsResponseData
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAppService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
    ): NewsResponseData
}