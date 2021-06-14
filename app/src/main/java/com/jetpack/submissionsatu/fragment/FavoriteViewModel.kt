package com.jetpack.submissionsatu.fragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.repository.Repository

class FavoriteViewModel(private val favRepository: Repository) : ViewModel() {
    fun getFavoriteMovies(context: Context?): LiveData<PagedList<MovieEntity>> =
        favRepository.getMoviesFav(context)

    fun getFavoriteTV(context: Context?): LiveData<PagedList<TvShowEntity>> =
        favRepository.getTVShowsFav(context)

    fun setFavListMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFav!!
        favRepository.setMoviesFav(movieEntity, newState)
    }

    fun setFavListTVShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFav!!
        favRepository.setTVShowsFav(tvShowEntity, newState)
    }

}