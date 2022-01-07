package com.amoronk.newsapp.di.module

import android.content.Context
import androidx.room.Room
import com.amoronk.newsapp.repo.local.DATABASE_NAME
import com.amoronk.newsapp.repo.local.NewsAppDAO
import com.amoronk.newsapp.repo.local.NewsAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NewsAppDatabase {
        return Room.databaseBuilder(context, NewsAppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAppDAO(roomDatabase: NewsAppDatabase): NewsAppDAO = roomDatabase.newsAppDAO()
}