package com.jetpack.submissionsatu.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity
import com.jetpack.submissionsatu.source.LocalDataSource
import com.jetpack.submissionsatu.util.LiveDataTestUtil
import com.jetpack.submissionsatu.source.RemoteDataSource
import com.jetpack.submissionsatu.util.AppExecutors
import com.jetpack.submissionsatu.vo.Resource
import com.naufal.moviepedia.util.PagedListUtil
import com.naufal.moviepedia.util.TestExecutor
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

    private val fakeRepository = FakeRepository(remote, local, appExecutors)

    private val movieResponses = DataKolektif.getDataMovies()
    private val tvResponses = DataKolektif.getDataTv()


    @Test
    fun getAllMovies() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getAllDataMovie()).thenReturn(dataSourceFactory)
        fakeRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        Mockito.verify(local).getAllDataMovie()
        assertNotNull(movieEntities.body)
        assertEquals(movieResponses.size.toLong(), movieEntities.body?.size?.toLong())
    }

    @Test
    fun getAllTV() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        Mockito.`when`(local.getAllDataTVShow()).thenReturn(dataSourceFactory)
        fakeRepository.getAllTV()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(tvResponses))
        Mockito.verify(local).getAllDataTVShow()
        assertNotNull(tvEntities.body)
        assertEquals(tvResponses.size.toLong(), tvEntities.body?.size?.toLong())
    }

    @Test
    fun getOneMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movieResponses[0]
        Mockito.`when`(local.getMovieById(movieResponses[0]?.id!!)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtil.getValue(fakeRepository.getOneMovie(movieResponses[0]?.id!!))
        Mockito.verify(local).getMovieById(movieResponses[0]?.id!!)
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.body?.title)
        assertEquals(movieResponses[0]?.title, movieEntities.body?.title)
    }

    @Test
    fun getOneTV() {
        val dummyTV = MutableLiveData<TvShowEntity>()
        dummyTV.value = tvResponses[0]
        Mockito.`when`(local.getTVShowById(tvResponses[0]?.id!!)).thenReturn(dummyTV)

        val tvEntities = LiveDataTestUtil.getValue(fakeRepository.getOneTV(tvResponses[0]?.id!!))
        Mockito.verify(local).getTVShowById(tvResponses[0]?.id!!)
        assertNotNull(tvEntities)
        assertNotNull(tvEntities.body?.title)
        assertEquals(tvResponses[0]?.title, tvEntities.body?.title)
    }

    @Test
    fun getFavoriteMovies(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        fakeRepository.getMoviesFav(null)

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        Mockito.verify(local).getFavMovies()
        assertNotNull(movieEntities)
    }

    @Test
    fun getFavoriteTV(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        Mockito.`when`(local.getFavTVShows()).thenReturn(dataSourceFactory)
        fakeRepository.getTVShowsFav(null)

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(tvResponses))
        Mockito.verify(local).getFavTVShows()
        assertNotNull(tvEntities)
    }

    @Test
    fun setFavoriteMovies(){
        val dummy = movieResponses[0]
        fakeRepository.setMoviesFav(dummy!!, true)

        Mockito.verify(local, Mockito.times(1)).updateFavMovie(dummy, true)
    }

    @Test
    fun setFavoriteTV(){
        val dummy = tvResponses[0]
        fakeRepository.setTVShowsFav(dummy!!, true)

        Mockito.verify(local, Mockito.times(1)).updateFavTVShow(dummy, true)
    }
}