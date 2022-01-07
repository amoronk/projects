package com.amoronk.newsapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amoronk.newsapp.ui.NewsListUi
import com.amoronk.newsapp.ui.theme.NewsAppTheme
import com.amoronk.newsapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {

                NewsContent(
                    viewModel = viewModel,
                    openBrowser = { url -> url?.let { showWebPage(it) } })
            }
        }
    }

    private fun showWebPage(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setColorScheme(CustomTabsIntent.COLOR_SCHEME_SYSTEM)
            .build()

        try {
            customTabsIntent.launchUrl(this, Uri.parse(url))
        } catch (e: Exception) {
        }
    }
}


@Composable
fun NewsContent(
    viewModel: MainViewModel,
    openBrowser: (String?) -> Unit,
) {

    val onLoad = viewModel.onLoad.value
    if (!onLoad) {
        viewModel.onLoad.value = true
        viewModel.getNewsData()
    }

    val data = viewModel.newsList.value

    val loading: Boolean = viewModel.loading.value

    NewsListUi(loading = loading, data = data, openBrowser = openBrowser)


}