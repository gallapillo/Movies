package com.gallapillo.movies.presentation.movie_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.gallapillo.movies.common.HtmlText
import com.gallapillo.movies.presentation.movie_list.MovieListViewModel
import com.gallapillo.movies.presentation.theme.BackGround
import com.gallapillo.movies.presentation.theme.GoogleSansBold
import com.gallapillo.movies.presentation.theme.GoogleSansMedium
import com.gallapillo.movies.presentation.theme.GoogleSansRegular

@Composable
fun DetailScreen(
    viewModel: MovieListViewModel = hiltViewModel(),
    id: String
) {
    val currentItem = viewModel.state.value.movies.firstOrNull {
        it.id == id.toInt()
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
            .background(BackGround)
    ) {
        LazyColumn {
            item {
                Image(
                    painter = rememberImagePainter(currentItem?.image?.medium),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(4.dp)),
                )
                Text (
                    text = currentItem?.name ?: "Hello",
                    fontSize = 32.sp,
                    fontFamily = GoogleSansBold,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row (
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = "Raiting: ",
                        fontFamily = GoogleSansBold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = currentItem?.rating?.average.toString(),
                        fontFamily = GoogleSansRegular,
                        fontSize = 18.sp
                    )
                }
                Row (
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = "Genere: ",
                        fontFamily = GoogleSansBold,
                        fontSize = 18.sp
                    )
                    currentItem?.genres?.take(2)?.forEach {
                        Text(
                            " [$it] ",
                            fontSize = 18.sp
                        )
                    }
                }
                HtmlText(
                    html = currentItem?.summary ?: "",
                    modifier = Modifier.padding(top = 10.dp),
                )
            }
        }
    }
}