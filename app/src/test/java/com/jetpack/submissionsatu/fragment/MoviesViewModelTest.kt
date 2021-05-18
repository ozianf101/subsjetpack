package com.jetpack.submissionsatu.fragment

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getListMovie() {
        val movie = viewModel.getMoviesData()
        Assert.assertNotNull(movie)
        Assert.assertEquals(10, movie.size)
    }

}