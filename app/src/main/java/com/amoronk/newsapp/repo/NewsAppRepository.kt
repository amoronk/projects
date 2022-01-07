package com.amoronk.newsapp.repo

import android.content.Context
import com.amoronk.newsapp.data.NewsItem
import com.amoronk.newsapp.repo.local.NewsAppCache
import com.amoronk.newsapp.repo.remote.NewsAppService
import com.amoronk.newsapp.utils.NetworkUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsAppRepository @Inject constructor(
    private val newsAppCache: NewsAppCache,
    private val newsAppService: NewsAppService,
    @ApplicationContext private val context: Context
) {

    fun getNews(): Flow<Result<List<NewsItem>>> {
        return if (NetworkUtil.isOnline(context)) {
            getNewsFromRemote()
        } else {
            newsAppCache.observeNewsItems().map {
                Result.Success(it)
            }
        }
    }

    private fun getNewsFromRemote(): Flow<Result<List<NewsItem>>> {
        return flow {
            emit(Result.Loading)
            try {
                val result = newsAppService.getNews()
                if (result.status == "ok") {
                    newsAppCache.saveNewsItem(result.results)
                    emit(Result.Success(result.results))
                } else emit(Result.Error(Throwable(result.message)))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
    }
}