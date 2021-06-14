package com.jetpack.submissionsatu.di

import android.content.Context
import com.jetpack.submissionsatu.local.DbConfig
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.source.LocalDataSource
import com.jetpack.submissionsatu.source.RemoteDataSource
import com.jetpack.submissionsatu.util.AppExecutors

object Injection {
    fun provideRepository(context: Context?): Repository {
        val database = DbConfig.getInstance(context)

        val remoteDataResource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.contentDao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataResource, localDataSource, appExecutors)
    }
}