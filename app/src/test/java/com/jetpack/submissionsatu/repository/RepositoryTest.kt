package com.jetpack.submissionsatu.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.source.LiveDataTestUtil
import com.jetpack.submissionsatu.source.RemoteDataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class RepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val fakeRepository = FakeRepository(remote)

    private val movieResponses = DataKolektif.getRemoteDataMovies()
    private val tvResponses = DataKolektif.getRemoteDataTV()
    private val movieId = movieResponses[0].id
    private val tvId = tvResponses[0].id
    private val detailMovieResponse = movieId?.let { DataKolektif.getRemoteDetailDataMovies(it) }
    private val detailTVResponse = tvId?.let { DataKolektif.getRemoteDetailDataTV(it) }

    @Test
    fun getAllMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onReceived(movieResponses)
            null
        }.`when`(remote).getMovies(any())
        val movieItems = LiveDataTestUtil.getValue(fakeRepository.getAllMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieItems)
        assertEquals(movieResponses.size.toLong(), movieItems?.size?.toLong())
    }

    @Test
    fun getAllTV() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvCallback)
                .onReceived(tvResponses)
            null
        }.`when`(remote).getTvShows(any())
        val tvItems = LiveDataTestUtil.getValue(fakeRepository.getAllTV())
        verify(remote).getTvShows(any())
        assertNotNull(tvItems)
        assertEquals(tvResponses.size.toLong(), tvItems?.size?.toLong())
    }

    @Test
    fun getOneMovie() {
        doAnswer {
            if (detailMovieResponse != null) {
                (it.arguments[1] as RemoteDataSource.LoadDetailMoviesCallback)
                    .onReceived(detailMovieResponse)
            }
        }.`when`(remote).getDetailMovies(eq(movieId), any())

        val movieEntity = LiveDataTestUtil.getValue(fakeRepository.getOneMovie(movieId))

        verify(remote)
            .getDetailMovies(eq(movieId), any())

        assertNotNull(movieEntity)
    }

    @Test
    fun getOneTV() {
        doAnswer {
            if (detailTVResponse != null) {
                (it.arguments[1] as RemoteDataSource.LoadDetailTvCallback)
                    .onReceived(detailTVResponse)
            }
        }.`when`(remote).getDetailTvShow(eq(tvId), any())

        val tvEntity = LiveDataTestUtil.getValue(fakeRepository.getOneTV(tvId))

        verify(remote)
            .getDetailTvShow(eq(tvId), any())

        assertNotNull(tvEntity)
    }
}