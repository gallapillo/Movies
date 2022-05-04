package com.gallapillo.movies.presentation.movie_list

import com.gallapillo.movies.domain.model.Movies

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movies> = emptyList(),
    val error: String = ""
)
