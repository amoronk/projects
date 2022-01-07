package com.amoronk.newsapp.repo.local

import com.amoronk.newsapp.data.NewsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsAppCache @Inject internal constructor(
    private val newsAppDAO: NewsAppDAO
) {

    fun observeNewsItems(): Flow<List<NewsItem>> {
        return newsAppDAO.observeNewsItems()
    }

    suspend fun saveNewsItem(newsItem: List<NewsItem>) {
        newsAppDAO.insertNewsItem(newsItem)
    }

}