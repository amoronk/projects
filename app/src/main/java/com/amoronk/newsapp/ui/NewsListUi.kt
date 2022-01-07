package com.amoronk.newsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amoronk.newsapp.data.NewsItem
import com.amoronk.newsapp.ui.bar.MainTopBar
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun NewsListUi(loading: Boolean, data: List<NewsItem>, openBrowser: (String?) -> Unit) {
    Scaffold(
        topBar = { MainTopBar() },
        content = {
            Column {
                if (loading) {
                    LoadingUi()
                }
                NewsContent(newsList = data, openBrowser = openBrowser)
            }
        }
    )
}

@Composable
private fun NewsColumnItem(news: NewsItem, onClick: () -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Box(Modifier.fillMaxWidth()) {
            Image(
                painter = rememberCoilPainter(news.url_image),
                contentDescription = news.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Surface(
                color = Color.Black,
                modifier = Modifier.alpha(0.7f)
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Column(modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(6.dp)) {
                Text(
                    text = news.title ?: "",
                    maxLines = 2,
                    fontSize = 18.sp,
                    color = Color.White,
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = news.author ?: "",
                    maxLines = 1,
                    color = Color.White,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Composable
private fun NewsContent(
    newsList: List<NewsItem>,
    openBrowser: (String?) -> Unit
) {
    Box(modifier = Modifier.background(color = MaterialTheme.colors.surface)) {
            LazyColumn(contentPadding = PaddingValues(top = 2.dp, bottom = 2.dp)) {
                itemsIndexed(items = newsList) { _, newsItem ->
                    NewsColumnItem(
                        news = newsItem,
                        onClick = { openBrowser(newsItem.url) }
                    )
                }
            }
    }
}