package com.jetpack.submissionsatu.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.model.DataEntitasTv
import com.jetpack.submissionsatu.repository.Repository

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShows(): LiveData<ArrayList<DataEntitasTv?>?> = repository.getAllTV()
}