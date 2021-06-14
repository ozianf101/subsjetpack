package com.jetpack.submissionsatu.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.vo.Resource
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

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie : Resource<MovieEntity> = Resource.success(DataKolektif.getDataMovies()[0])
    private val dummyTV : Resource<TvShowEntity> = Resource.success(DataKolektif.getDataTv()[0])
    private val movieId = dummyMovie.body?.id
    private val tvId = dummyTV.body?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var detailRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<TvShowEntity>>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(detailRepository)
        movieId?.let { viewModel.setSelectedMovie(it) }
        tvId?.let { viewModel.setSelectedTV(it) }
    }

    @Test
    fun getDetailMovie() {
        val movies = MutableLiveData<Resource<MovieEntity>>()
        movies.value = dummyMovie

        Mockito.`when`(movieId?.let { detailRepository.getOneMovie(it) }).thenReturn(movies)
        viewModel.getMovie().observeForever(movieObserver)

        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTV() {
        val tv = MutableLiveData<Resource<TvShowEntity>>()
        tv.value = dummyTV

        Mockito.`when`(tvId?.let { detailRepository.getOneTV(it) }).thenReturn(tv)
        viewModel.getTV().observeForever(tvObserver)

        verify(tvObserver).onChanged(dummyTV)
    }

    @Test
    fun setFavoriteMovies(){
        val movies = MutableLiveData<Resource<MovieEntity>>()
        movies.value = dummyMovie

        Mockito.`when`(movieId?.let { detailRepository.getOneMovie(it) }).thenReturn(movies)
        viewModel.getMovie().observeForever(movieObserver)

        Mockito.doNothing()
            .`when`(detailRepository).setMoviesFav(DataKolektif.getDataMovies()[0]!!, true)

        viewModel.setFavMovie(DataKolektif.getDataMovies()[0]!!)

        verify(detailRepository).setMoviesFav(DataKolektif.getDataMovies()[0]!!, true)
    }

    @Test
    fun setFavoriteTV(){
        val tv = MutableLiveData<Resource<TvShowEntity>>()
        tv.value = dummyTV

        Mockito.`when`(tvId?.let { detailRepository.getOneTV(it) }).thenReturn(tv)
        viewModel.getTV().observeForever(tvObserver)

        Mockito.doNothing().`when`(detailRepository).setTVShowsFav(DataKolektif.getDataTv()[0]!!, true)

        viewModel.setFavTVShow(DataKolektif.getDataTv()[0]!!)

        verify(detailRepository).setTVShowsFav(DataKolektif.getDataTv()[0]!!, true)

    }
}