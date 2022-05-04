package com.gallapillo.movies.domain.use_cases

import com.gallapillo.movies.common.Resource
import com.gallapillo.movies.domain.model.Movies
import com.gallapillo.movies.data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movies>>> = flow {
        try {
            emit(Resource.Loading<List<Movies>>())
            val movies = repository.getAllMovies()
            emit(Resource.Success<List<Movies>>(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "AN UNEXPECTED ERROR OCCURRED"))
        } catch (e: IOException) {
            emit(Resource.Error("ERROR WITH INTERNET CONNECTION"))
        }
    }
}