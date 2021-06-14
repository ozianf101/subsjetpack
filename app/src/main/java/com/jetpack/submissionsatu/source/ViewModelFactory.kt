package com.jetpack.submissionsatu.source

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetpack.submissionsatu.di.Injection
import com.jetpack.submissionsatu.fragment.FavoriteViewModel
import com.jetpack.submissionsatu.fragment.MoviesViewModel
import com.jetpack.submissionsatu.fragment.TvShowViewModel
import com.jetpack.submissionsatu.repository.Repository
import com.jetpack.submissionsatu.ui.detail.DetailViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(repository) as T
            }
            else -> throw Throwable("invalid " + modelClass.name)
        }
    }
}