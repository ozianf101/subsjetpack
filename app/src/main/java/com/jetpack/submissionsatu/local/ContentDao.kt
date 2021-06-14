package com.jetpack.submissionsatu.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity

@Dao
interface ContentDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tv_shows")
    fun getTVShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movies WHERE is_fav = 1")
    fun getFavMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tv_shows WHERE is_fav = 1")
    fun getFavTVShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMoviesById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tv_shows WHERE id = :id")
    fun getTVShowsById(id: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTVShow(tvShow: TvShowEntity)

}