package com.gallapillo.movies.presentation.movie_list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gallapillo.movies.domain.model.Movies

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state = viewModel.allMovies.value
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(state.movies) { movie ->
                MovieItem(item = movie)
            }
        }
    }
}

@Composable
fun MovieItem(item: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = item.id.toString())
        Text(text = item.name)
    }
}