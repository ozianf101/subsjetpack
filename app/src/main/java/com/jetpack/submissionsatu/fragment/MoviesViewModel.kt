package com.jetpack.submissionsatu.fragment

import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DataEntitas

class MoviesViewModel : ViewModel() {

    fun getMoviesData() : List<DataEntitas> = DataKolektif.getDataMovies()
}