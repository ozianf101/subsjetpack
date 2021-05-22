package com.jetpack.submissionsatu.api

import com.jetpack.submissionsatu.data.Helper.API_KEY
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow
import com.jetpack.submissionsatu.model.MovieResponse
import com.jetpack.submissionsatu.model.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoint {

    @GET("movie/popular?api_key=$API_KEY")
    fun getListMovies(
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getDetailMovies(
        @Path("movie_id") id: Int
    ): Call<DetailMovie>

    @GET("tv/popular?api_key=$API_KEY")
    fun getListTVShows(
        @Query("page") page: Int
    ): Call<TvResponse>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    fun getDetailTVShows(
        @Path("tv_id") id: Int
    ): Call<DetailTvShow>
}