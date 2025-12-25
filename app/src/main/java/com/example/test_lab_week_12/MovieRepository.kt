package com.example.test_lab_week_13

import com.example.test_lab_week_13.api.MovieService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lab_week_13.database.MovieDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers
import com.example.lab_week_13.model.Movie

class MovieRepository(private val movieService: MovieService, movieDatabase: MovieDatabase) {
    private val apiKey = "203ed840db404d8b123e661f9595e5af"
    // LiveData that contains a list of movies
    private val movieLiveData = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = movieLiveData
    // LiveData that contains an error message
    private val errorLiveData = MutableLiveData<String>()
    val error: LiveData<String>
        get() = errorLiveData
    // fetch movies from the API
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
// emit the list of popular movies from the API
            emit(movieService.getPopularMovies(apiKey).results)
// use Dispatchers.IO to run this coroutine on a shared pool of threads
        }.flowOn(Dispatchers.IO)
    }
}
