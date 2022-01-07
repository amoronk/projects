package com.amoronk.newsapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_table")
data class NewsItem(
    @field:SerializedName("author")
    var author: String?,

    @field:SerializedName("title")
    var title: String?,

    @field:SerializedName("description")
    var description: String?,

    @field:SerializedName("url")
    var url: String?,

    @field:SerializedName("urlToImage")
    var url_image: String?,

    @field:SerializedName("publishedAt")
    var published_at: String?,

    @field:SerializedName("content")
    var content: String?
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}