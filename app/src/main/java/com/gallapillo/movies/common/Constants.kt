package com.gallapillo.movies.common

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

object Constants {
    const val SPLASH_SCREEN_ROUTE = "splash_screen"
    const val MOVIE_LIST_SCREEN_ROUTE = "movie_list_scree"
    const val DETAILS_SCREEN_ROUTE = "details_screen"
}

@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context -> TextView(context) },
        modifier = modifier,
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)}
    )
}