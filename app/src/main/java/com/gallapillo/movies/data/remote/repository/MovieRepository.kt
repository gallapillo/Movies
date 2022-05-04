package com.gallapillo.movies.data.remote.repository

import com.gallapillo.movies.data.remote.models.Movies
import retrofit2.Response

interface MovieRepository {
    suspend fun getAllMovies() : Response<List<Movies>>
}