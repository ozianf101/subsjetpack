package com.jetpack.submissionsatu.ui.detail

import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DataEntitas

class DetailViewModel : ViewModel() {
    private lateinit var movieId : String
    private lateinit var tvId : String

    fun setSelectedMovie(movieId : String){
        this.movieId = movieId
    }

    fun setSelectedTV(tvId : String){
        this.tvId = tvId
    }

    fun getMovie() : DataEntitas {
        return DataKolektif.getDataMovies().first{ it.id == movieId}
    }

    fun getTV() : DataEntitas {
        return DataKolektif.getDataTv().first{ it.id == tvId}
    }

}