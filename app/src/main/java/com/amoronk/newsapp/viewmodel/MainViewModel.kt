package com.amoronk.newsapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amoronk.newsapp.data.NewsItem
import com.amoronk.newsapp.repo.NewsAppRepository
import com.amoronk.newsapp.repo.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsAppRepository,
) : ViewModel() {

    val newsList: MutableState<List<NewsItem>> = mutableStateOf(ArrayList())
    val onLoad: MutableState<Boolean> = mutableStateOf(false)
    val loading = mutableStateOf(false)

    fun getNewsData() {
        repository.getNews()
            .onEach {
                when (it) {
                    is Result.Success<List<NewsItem>> -> {
                        loading.value = false
                        it.data?.let { data -> newsList.value = data }
                    }
                    is Result.Error -> {
                        loading.value = false
                    }
                    is Result.Loading -> loading.value = true
                }
            }
            .launchIn(viewModelScope)
    }
}