package com.jetpack.submissionsatu.source

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.jetpack.submissionsatu.model.*
import com.jetpack.submissionsatu.vo.Resource

interface DataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getAllTV(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getOneMovie(movieID: Int): LiveData<Resource<MovieEntity>>
    fun getOneTV(tvShowID: Int): LiveData<Resource<TvShowEntity>>

    fun setMoviesFav(movie: MovieEntity, state: Boolean)
    fun setTVShowsFav(tvShow: TvShowEntity, state: Boolean)

    fun getMoviesFav(context: Context?): LiveData<PagedList<MovieEntity>>
    fun getTVShowsFav(context: Context?): LiveData<PagedList<TvShowEntity>>
}