package com.amoronk.newsapp.data

import com.google.gson.annotations.SerializedName

data class NewsResponseData(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("totalResults")
    val total_results: Int,

    @field:SerializedName("articles")
    val results: List<NewsItem>,

    @field:SerializedName("message")
    val message: String
)