package com.gallapillo.movies.data.repository

import com.gallapillo.movies.domain.model.Movies

interface MovieRepository {
    suspend fun getAllMovies() : List<Movies>
}