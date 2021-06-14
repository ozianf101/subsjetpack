package com.jetpack.submissionsatu.adapter

import com.jetpack.submissionsatu.model.TvShowEntity

interface ContentTvCallback {
    fun onItemClicked(dataTv: TvShowEntity)
}