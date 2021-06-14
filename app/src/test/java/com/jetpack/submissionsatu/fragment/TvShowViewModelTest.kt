package com.jetpack.submissionsatu.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.model.TvShowEntity
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
class TvShowViewModelTest() {
    private lateinit var viewModel : TvShowViewModel
    private val dummyTV : Resource<TvShowEntity> = Resource.success(DataKolektif.getDataTv()[0])
    private val tvId = dummyTV.body?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: Repository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(tvRepository)
    }

    @Test
    fun getTV() {
        val dummyTV = Resource.success(pagedList)
        Mockito.`when`(dummyTV.body?.size).thenReturn(5)
        val tv = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tv.value = dummyTV

        Mockito.`when`(tvRepository.getAllTV()).thenReturn(tv)
        val tvEntities = viewModel.getTvShows().value?.body
        Mockito.verify(tvRepository).getAllTV()
        assertNotNull(tvEntities)
        assertEquals(5, tvEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTV)
    }

    @Test
    fun setFavoriteTV(){
        val tv = MutableLiveData<Resource<TvShowEntity>>()
        tv.value = dummyTV

        Mockito.lenient().`when`(tvId?.let { tvRepository.getOneTV(it) }).thenReturn(tv)

        Mockito.doNothing().`when`(tvRepository).setTVShowsFav(DataKolektif.getDataTv()[0]!!, true)

        viewModel.setFavListTVShow(DataKolektif.getDataTv()[0]!!)

        verify(tvRepository).setTVShowsFav(DataKolektif.getDataTv()[0]!!, true)

    }
}