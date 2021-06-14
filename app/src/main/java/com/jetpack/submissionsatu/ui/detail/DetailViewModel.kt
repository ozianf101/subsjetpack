package com.jetpack.submissionsatu.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.vo.Resource

class DetailViewModel(private val detailRepository: Repository) : ViewModel() {
    private var movieId: Int = 0
    private var tvId: Int = 0

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTV(tvId: Int) {
        this.tvId = tvId
    }

    fun getMovie(): LiveData<Resource<MovieEntity>> = detailRepository.getOneMovie(movieId)

    fun getTV(): LiveData<Resource<TvShowEntity>> = detailRepository.getOneTV((tvId))

    fun setFavMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFav!!
        detailRepository.setMoviesFav(movieEntity, newState)

    }

    fun setFavTVShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFav!!
        detailRepository.setTVShowsFav(tvShowEntity, newState)
    }

}