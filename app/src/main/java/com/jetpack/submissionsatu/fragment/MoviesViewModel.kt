package com.jetpack.submissionsatu.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpack.submissionsatu.model.DataEntitasMovie
import com.jetpack.submissionsatu.repository.Repository

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getMoviesData() : LiveData<ArrayList<DataEntitasMovie?>?> =repository.getAllMovies()
}