package com.jetpack.submissionsatu.di

import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.source.RemoteDataSource

object Injection {
    fun provideRepository(): Repository {
        val remoteDataSource = RemoteDataSource()

        return Repository.getInstance(remoteDataSource)
    }
}