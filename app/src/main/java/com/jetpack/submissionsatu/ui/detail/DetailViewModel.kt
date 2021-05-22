package com.jetpack.submissionsatu.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow
import com.jetpack.submissionsatu.repository.Repository

class DetailViewModel(private val detailRepository: Repository) : ViewModel() {
    private var movieId: Int = 0
    private var tvId: Int = 0

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTV(tvId: Int) {
        this.tvId = tvId
    }

    fun getMovie(): LiveData<DetailMovie?> = detailRepository.getOneMovie(movieId)

    fun getTV(): LiveData<DetailTvShow?> = detailRepository.getOneTV((tvId))

}