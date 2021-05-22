package com.jetpack.submissionsatu.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.DataEntitasTv
import com.jetpack.submissionsatu.repository.Repository
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
class TvShowViewModelTest() {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: Repository

    @Mock
    private lateinit var observer: Observer<ArrayList<DataEntitasTv?>?>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(tvRepository)
    }

    @Test
    fun getListTvShows() {
        val dummyTV = DataKolektif.getDataTv()
        val tv = MutableLiveData<ArrayList<DataEntitasTv?>?>()
        tv.value = dummyTV

        Mockito.`when`(tvRepository.getAllTV()).thenReturn(tv)
        val tvEntities = viewModel.getTvShows().value
        verify(tvRepository).getAllTV()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTV)
    }
}