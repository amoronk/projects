package com.amoronk.newsapp.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amoronk.newsapp.data.NewsItem

const val DATABASE_NAME = "news_app_db"

@Database(
    version = 1,
    entities = [NewsItem::class]
)
abstract class NewsAppDatabase : RoomDatabase() {
    abstract fun newsAppDAO(): NewsAppDAO
}