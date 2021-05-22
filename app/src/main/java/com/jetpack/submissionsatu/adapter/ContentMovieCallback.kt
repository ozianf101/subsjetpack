package com.jetpack.submissionsatu.adapter

import com.jetpack.submissionsatu.model.DataEntitasMovie

interface ContentMovieCallback {
    fun onItemClicked(dataMovie: DataEntitasMovie)
}