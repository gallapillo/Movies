package com.gallapillo.movies.domain.repository

import com.gallapillo.movies.data.remote.MovieApi
import com.gallapillo.movies.data.remote.models.Movies
import com.gallapillo.movies.data.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    override suspend fun getAllMovies(): Response<List<Movies>> = movieApi.getAllMovies()
}