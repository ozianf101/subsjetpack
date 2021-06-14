package com.jetpack.submissionsatu.adapter

import com.jetpack.submissionsatu.model.MovieEntity

interface ContentMovieCallback {
    fun onItemClicked(dataMovie: MovieEntity)
}