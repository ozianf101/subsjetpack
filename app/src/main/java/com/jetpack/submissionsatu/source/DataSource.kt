package com.jetpack.submissionsatu.source

import androidx.lifecycle.LiveData
import com.jetpack.submissionsatu.model.DataEntitasMovie
import com.jetpack.submissionsatu.model.DataEntitasTv
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow

interface DataSource {

    fun getAllMovies(): LiveData<ArrayList<DataEntitasMovie?>?>
    fun getAllTV(): LiveData<ArrayList<DataEntitasTv?>?>
    fun getOneMovie(id: Int?): LiveData<DetailMovie?>
    fun getOneTV(id: Int?): LiveData<DetailTvShow?>
}