package com.gallapillo.movies.presentation.movie_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gallapillo.movies.common.Resource
import com.gallapillo.movies.domain.use_cases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _allMovies = mutableStateOf<MovieListState>(MovieListState())
    val allMovies: State<MovieListState> = _allMovies

    init {
        getMovies()
    }

    private fun getMovies() {
        getMoviesUseCase().onEach { res ->
            when(res) {
                is Resource.Success -> {
                    _allMovies.value = MovieListState(movies = res.data ?: emptyList())
                }
                is Resource.Error -> {
                    _allMovies.value = MovieListState(error = res.message ?: "Unknown error")
                }
                is Resource.Loading -> {
                    _allMovies.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}