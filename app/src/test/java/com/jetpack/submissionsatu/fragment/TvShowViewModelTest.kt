package com.jetpack.submissionsatu.fragment

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest(){
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getListTvShows() {
        val movie = viewModel.getTvShows()
        Assert.assertNotNull(movie)
        Assert.assertEquals(10, movie.size)
    }
}