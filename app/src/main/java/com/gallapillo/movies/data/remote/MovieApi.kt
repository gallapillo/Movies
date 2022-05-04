package com.gallapillo.movies.data.remote

import com.gallapillo.movies.domain.model.Movies
import retrofit2.http.GET

interface MovieApi {

    @GET("/shows")
    suspend fun getAllMovies() : List<Movies>
}