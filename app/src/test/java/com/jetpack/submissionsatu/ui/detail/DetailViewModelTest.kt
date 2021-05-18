package com.jetpack.submissionsatu.ui.detail

import com.jetpack.submissionsatu.data.DataKolektif
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel : DetailViewModel
    private val dummyMovie = DataKolektif.getDataMovies()[0]
    private val dummyTV = DataKolektif.getDataTv()[0]
    private val movieId = dummyMovie.id
    private val tvId = dummyTV.id

    @Before
    fun loading(){
        viewModel = DetailViewModel()
        viewModel.setSelectedTV(tvId)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun testGetMovie() {
        val movies = viewModel.getMovie()

        Assert.assertNotNull(movies)
        assertEquals(dummyMovie.id, movies.id)
        assertEquals(dummyMovie.title, movies.title)
        assertEquals(dummyMovie.genre, movies.genre)
        assertEquals(dummyMovie.rating, movies.rating, 0.0001)
        assertEquals(dummyMovie.overview, movies.overview)
        assertEquals(dummyMovie.imgPoster, movies.imgPoster)
        assertEquals(dummyMovie.imgBackground, movies.imgBackground)
        assertEquals(dummyMovie.released, movies.released)
        assertEquals(dummyMovie.runtime, movies.runtime)
        assertEquals(dummyMovie.language, movies.language)
    }

    @Test
    fun testGetTV() {
        val tv = viewModel.getTV()

        Assert.assertNotNull(tv)
        assertEquals(dummyTV.id, tv.id)
        assertEquals(dummyTV.title, tv.title)
        assertEquals(dummyTV.genre, tv.genre)
        assertEquals(dummyTV.rating, tv.rating, 0.0001)
        assertEquals(dummyTV.overview, tv.overview)
        assertEquals(dummyTV.imgPoster, tv.imgPoster)
        assertEquals(dummyTV.imgBackground, tv.imgBackground)
        assertEquals(dummyTV.released, tv.released)
        assertEquals(dummyTV.runtime, tv.runtime)
        assertEquals(dummyTV.language, tv.language)
    }
}