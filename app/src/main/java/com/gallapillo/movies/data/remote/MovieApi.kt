package com.gallapillo.movies.data.remote

import com.gallapillo.movies.data.remote.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("/shows")
    suspend fun getAllMovies() : Response<List<Movies>>
}