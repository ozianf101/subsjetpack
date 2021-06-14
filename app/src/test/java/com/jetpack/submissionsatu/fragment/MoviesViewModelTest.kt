package com.jetpack.submissionsatu.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {
    private lateinit var viewModel : MoviesViewModel
    private val dummyMovie : Resource<MovieEntity> = Resource.success(DataKolektif.getDataMovies()[0])
    private val movieId = dummyMovie.body?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(pagedList)
        Mockito.`when`(dummyMovies.body?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        Mockito.`when`(movieRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMoviesData().value?.body
        Mockito.verify(movieRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getMoviesData().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun setFavoriteMovies(){
        val movies = MutableLiveData<Resource<MovieEntity>>()
        movies.value = dummyMovie

        Mockito.lenient().`when`(movieId?.let { movieRepository.getOneMovie(it) }).thenReturn(movies)

        Mockito.doNothing()
            .`when`(movieRepository).setMoviesFav(DataKolektif.getDataMovies()[0]!!, true)

        viewModel.setFavListMovie(DataKolektif.getDataMovies()[0]!!)

        verify(movieRepository).setMoviesFav(DataKolektif.getDataMovies()[0]!!, true)
    }

}