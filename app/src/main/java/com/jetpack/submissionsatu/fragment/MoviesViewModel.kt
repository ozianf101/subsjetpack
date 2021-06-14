package com.jetpack.submissionsatu.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.vo.Resource

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getMoviesData(): LiveData<Resource<PagedList<MovieEntity>>> = repository.getAllMovies()

    fun setFavListMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFav!!
        repository.setMoviesFav(movieEntity, newState)
    }
}