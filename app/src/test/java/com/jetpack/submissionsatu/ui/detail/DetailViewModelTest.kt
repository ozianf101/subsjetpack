package com.jetpack.submissionsatu.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow
import com.jetpack.submissionsatu.repository.Repository
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel : DetailViewModel
    private val dummyMovie = DataKolektif.getDataMovies()[0]
    private val dummyTV = DataKolektif.getDataTv()[0]
    private val movieId = dummyMovie!!.id
    private val tvId = dummyTV!!.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailRepository : Repository

    @Mock
    private lateinit var movieObserver: Observer<DetailMovie?>

    @Mock
    private lateinit var tvObserver: Observer<DetailTvShow?>

    @Before
    fun loading(){
        viewModel = DetailViewModel(detailRepository)
        viewModel.setSelectedTV(tvId!!)
        viewModel.setSelectedMovie(movieId!!)
    }

    @Test
    fun testGetMovie() {
        val movies = MutableLiveData<DetailMovie>()
        val detMovie = DetailMovie()

        movies.value = detMovie

        Mockito.`when`(movieId?.let { detailRepository.getOneMovie(it) }).thenReturn(movies)
        val movieEntity = viewModel.getMovie().value
        movieId?.let { verify(detailRepository).getOneMovie(it) }

        assertNotNull(movieEntity)
        assertEquals(detMovie.id, movieEntity?.id)
        assertEquals(detMovie.title, movieEntity?.title)
        assertEquals(detMovie.overview, movieEntity?.overview)
        assertEquals(detMovie.imgPoster, movieEntity?.imgPoster)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(detMovie)

    }

    @Test
    fun testGetTV() {
        val tvShow = MutableLiveData<DetailTvShow>()
        val detTv = DetailTvShow()

        tvShow.value = detTv

        Mockito.`when`(tvId?.let { detailRepository.getOneTV(it) }).thenReturn(tvShow)
        val TvShowEntity = viewModel.getTV().value
        tvId?.let { verify(detailRepository).getOneTV(it) }

        assertNotNull(TvShowEntity)
        assertEquals(detTv.id, TvShowEntity?.id)
        assertEquals(detTv.title, TvShowEntity?.title)
        assertEquals(detTv.overview, TvShowEntity?.overview)
        assertEquals(detTv.imgPoster, TvShowEntity?.imgPoster)

        viewModel.getTV().observeForever(tvObserver)
        verify(tvObserver).onChanged(detTv)
    }
}