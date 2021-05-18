package com.jetpack.submissionsatu.fragment

import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DataEntitas

class TvShowViewModel : ViewModel() {
    fun getTvShows() : List<DataEntitas> = DataKolektif.getDataTv()
}