package com.gallapillo.movies.presentation.movie_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gallapillo.movies.common.Screens
import com.gallapillo.movies.domain.model.Movies
import com.gallapillo.movies.presentation.theme.BackGround
import com.gallapillo.movies.presentation.theme.GoogleSansBold
import com.gallapillo.movies.presentation.theme.GoogleSansRegular
import com.gallapillo.movies.presentation.theme.Primary

@ExperimentalCoilApi
@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround),
        color = BackGround
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {
            items(state.movies) { movie ->
                MovieItem(item = movie, navController)
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 40.dp),
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MovieItem(
    item: Movies,
    navController: NavController
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${item.id.toString()}")
            },
        backgroundColor = Primary,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image.medium),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(4.dp)),
            )
            Column {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    fontFamily = GoogleSansBold
                )
                Row {
                    Text(
                        text = "Rating: ",
                        fontFamily = GoogleSansBold
                    )
                    Text (
                        text = item.rating.average.toString(),
                        fontFamily = GoogleSansRegular
                    )
                }
                Row {
                    Text(
                        text = "Premiered: ",
                        fontFamily = GoogleSansBold
                    )
                    Text(
                        text = item.premiered,
                        fontFamily = GoogleSansRegular
                    )
                }
                Row {
                    Text(
                        text = "Genre: ",
                        fontFamily = GoogleSansBold
                    )
                    item.genres.take(2).forEach {
                        Text(
                            text = " $it ",
                            fontFamily = GoogleSansRegular
                        )
                    }
                }
            }
        }
    }
}