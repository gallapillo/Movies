package com.gallapillo.movies.domain.repository

import com.gallapillo.movies.data.remote.MovieApi
import com.gallapillo.movies.domain.model.Movies
import com.gallapillo.movies.data.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    override suspend fun getAllMovies(): List<Movies> = movieApi.getAllMovies()
}