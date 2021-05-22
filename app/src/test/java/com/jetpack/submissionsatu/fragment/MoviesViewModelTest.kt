package com.jetpack.submissionsatu.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DataEntitasMovie
import com.jetpack.submissionsatu.repository.Repository
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
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: Repository

    @Mock
    private lateinit var observer: Observer<ArrayList<DataEntitasMovie?>?>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel(movieRepository)
    }

    @Test
    fun getListMovie() {
        val dummyMovies = DataKolektif.getDataMovies()
        val movies = MutableLiveData<ArrayList<DataEntitasMovie?>?>()
        movies.value = dummyMovies

        Mockito.`when`(movieRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMoviesData().value
        Mockito.verify(movieRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMoviesData().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

}