package com.amoronk.newsapp.repo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amoronk.newsapp.data.NewsItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsAppDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsItem(newsItems: List<NewsItem>)


    @Query("SELECT * FROM news_table")
    fun observeNewsItems(): Flow<List<NewsItem>>
}