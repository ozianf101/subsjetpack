package com.jetpack.submissionsatu.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.repository.Repository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.lenient
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest{
    private lateinit var viewModel : FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favoriteRepository: Repository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var tvObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListTV: PagedList<TvShowEntity>

    @Before
    fun setUp(){
        viewModel = FavoriteViewModel(favoriteRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = pagedListMovie
        lenient().`when`(dummyMovies.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies

        `when`(favoriteRepository.getMoviesFav(null)).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies(null).value
        Mockito.verify(favoriteRepository).getMoviesFav(null)
        assertNotNull(movieEntities)

        viewModel.getFavoriteMovies(null).observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteTV() {
        val dummyTV = pagedListTV
        lenient().`when`(dummyTV.size).thenReturn(5)
        val tv = MutableLiveData<PagedList<TvShowEntity>>()
        tv.value = dummyTV

        `when`(favoriteRepository.getTVShowsFav(null)).thenReturn(tv)
        val tvEntities = viewModel.getFavoriteTV(null).value
        Mockito.verify(favoriteRepository).getTVShowsFav(null)
        assertNotNull(tvEntities)

        viewModel.getFavoriteTV(null).observeForever(tvObserver)
        Mockito.verify(tvObserver).onChanged(dummyTV)
    }
}