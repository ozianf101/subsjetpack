package com.jetpack.submissionsatu.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jetpack.submissionsatu.model.*
import com.jetpack.submissionsatu.source.DataSource
import com.jetpack.submissionsatu.source.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<ArrayList<DataEntitasMovie?>?> {
        val movieResults = MutableLiveData<ArrayList<DataEntitasMovie?>?>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onReceived(movieResponse: ArrayList<DataEntitasMovie>) {
                val movieList = ArrayList<DataEntitasMovie?>()
                for (response in movieResponse) {
                    val movieResp = DataEntitasMovie(
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
                    movieList.add(movieResp)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTV(): LiveData<ArrayList<DataEntitasTv?>?> {
        val tvResults = MutableLiveData<ArrayList<DataEntitasTv?>?>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvCallback {
            override fun onReceived(tvResponse: ArrayList<DataEntitasTv>) {
                val tvList = ArrayList<DataEntitasTv?>()
                for (response in tvResponse) {
                    val tvResp = DataEntitasTv(
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
                    tvList.add(tvResp)
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
            override fun onReceived(detailTvShow: DetailTvShow) {

                val detTvResponse = DetailTvShow(
                    id = detailTvShow.id,
                    title = detailTvShow.title,
                    imgPoster = detailTvShow.imgPoster,
                    rating = detailTvShow.rating,
                    language = detailTvShow.language,
                    released = detailTvShow.released,
                    genre = detailTvShow.genre,
                    imgBackground = detailTvShow.imgBackground,
                    firstAir = detailTvShow.firstAir,
                    overview = detailTvShow.overview,
                    popularity = detailTvShow.popularity,
                    revenue = detailTvShow.revenue,
                    runtime = detailTvShow.runtime
                )

                detailTvResult.postValue(detTvResponse)
            }

        })
        return detailTvResult
    }
}