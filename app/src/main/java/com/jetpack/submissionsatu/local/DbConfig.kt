package com.jetpack.submissionsatu.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jetpack.submissionsatu.model.MovieEntity
import com.jetpack.submissionsatu.model.TvShowEntity


@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 4, exportSchema = false)
abstract class DbConfig : RoomDatabase() {

    abstract fun contentDao(): ContentDao

    companion object {
        @Volatile
        private var INSTANCE: DbConfig? = null

        fun getInstance(context: Context?): DbConfig =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context!!.applicationContext,
                    DbConfig::class.java,
                    "catalogue.db"
                ).fallbackToDestructiveMigration().build().apply {
                    INSTANCE = this
                }
            }
    }
}