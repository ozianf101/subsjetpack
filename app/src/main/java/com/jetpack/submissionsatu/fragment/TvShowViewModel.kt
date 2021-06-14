package com.jetpack.submissionsatu.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.vo.Resource

class TvShowViewModel(private val repository: Repository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = repository.getAllTV()

    fun setFavListTVShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFav!!
        repository.setTVShowsFav(tvShowEntity, newState)
    }

}