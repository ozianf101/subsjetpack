package com.jetpack.submissionsatu.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jetpack.submissionsatu.model.*
import com.jetpack.submissionsatu.source.DataSource
import com.jetpack.submissionsatu.source.RemoteDataSource

class FakeRepository(private val remoteDataSource: RemoteDataSource) : DataSource {

    override fun getAllMovies(): LiveData<ArrayList<DataEntitasMovie?>?> {
        val movieResults = MutableLiveData<ArrayList<DataEntitasMovie?>?>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onReceived(movieResp: ArrayList<DataEntitasMovie>) {
                val movieList = ArrayList<DataEntitasMovie?>()
                for (response in movieResp) {
                    val movieResponse = DataEntitasMovie(
                        id = response.id,
                        title = response.title,
                        imgPoster = response.imgPoster,
                        rating = response.rating,
                        language = response.language,
                        released = response.released,
                        genre = response.genre,
                        imgBackground = response.imgBackground,
                        firstAir = response.firstAir,
                        overview = response.overview,
                        popularity = response.popularity
                    )
                    movieList.add(movieResponse)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTV(): LiveData<ArrayList<DataEntitasTv?>?> {
        val tvResults = MutableLiveData<ArrayList<DataEntitasTv?>?>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvCallback {
            override fun onReceived(tvResp: ArrayList<DataEntitasTv>) {
                val tvList = ArrayList<DataEntitasTv?>()
                for (response in tvResp) {
                    val TvResponse = DataEntitasTv(
                        id = response.id,
                        title = response.title,
                        imgPoster = response.imgPoster,
                        rating = response.rating,
                        language = response.language,
                        released = response.released,
                        genre = response.genre,
                        imgBackground = response.imgBackground,
                        overview = response.overview,
                        popularity = response.popularity
                    )
                    tvList.add(TvResponse)
                }
                tvResults.postValue(tvList)
            }
        })
        return tvResults
    }

    override fun getOneMovie(id: Int?): LiveData<DetailMovie?> {
        val detailMovieResult = MutableLiveData<DetailMovie>()

        remoteDataSource.getDetailMovies(id!!, object : RemoteDataSource.LoadDetailMoviesCallback {
            override fun onReceived(detailMovie: DetailMovie) {

                val detMovieResponse = DetailMovie(
                    id = detailMovie.id,
                    title = detailMovie.title,
                    imgPoster = detailMovie.imgPoster,
                    rating = detailMovie.rating,
                    language = detailMovie.language,
                    released = detailMovie.released,
                    genre = detailMovie.genre,
                    imgBackground = detailMovie.imgBackground,
                    firstAir = detailMovie.firstAir,
                    overview = detailMovie.overview,
                    popularity = detailMovie.popularity,
                    revenue = detailMovie.revenue,
                    runtime = detailMovie.runtime
                )

                detailMovieResult.postValue(detMovieResponse)
            }

        })
        return detailMovieResult
    }

    override fun getOneTV(id: Int?): LiveData<DetailTvShow?> {
        val detailTvResult = MutableLiveData<DetailTvShow>()

        remoteDataSource.getDetailTvShow(id!!, object : RemoteDataSource.LoadDetailTvCallback {
            override fun onReceived(detailTv: DetailTvShow) {

                val detTvResponse = DetailTvShow(
                    id = detailTv.id,
                    title = detailTv.title,
                    imgPoster = detailTv.imgPoster,
                    rating = detailTv.rating,
                    language = detailTv.language,
                    released = detailTv.released,
                    genre = detailTv.genre,
                    imgBackground = detailTv.imgBackground,
                    firstAir = detailTv.firstAir,
                    overview = detailTv.overview,
                    popularity = detailTv.popularity,
                    revenue = detailTv.revenue,
                    runtime = detailTv.runtime
                )

                detailTvResult.postValue(detTvResponse)
            }

        })
        return detailTvResult
    }
}