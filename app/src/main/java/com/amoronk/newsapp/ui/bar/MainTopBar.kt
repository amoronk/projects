package com.amoronk.newsapp.ui.bar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun MainTopBar(
) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text = "Newsfeed", color = MaterialTheme.colors.onSurface)
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}