package com.jetpack.submissionsatu.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.jetpack.submissionsatu.data.Helper.TYPE_MOVIE
import com.jetpack.submissionsatu.data.Helper.TYPE_TVSHOW
import com.jetpack.submissionsatu.data.Helper.setGlideImage
import com.jetpack.submissionsatu.databinding.ActivityDetailBinding
import com.jetpack.submissionsatu.model.DetailMovie
import com.jetpack.submissionsatu.model.DetailTvShow
import com.jetpack.submissionsatu.source.RemoteDataSource
import com.jetpack.submissionsatu.source.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        val idData = intent.getIntExtra(EXTRA_DATA, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        Log.e("pass ID", "id data " + idData.toString())

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            idData.let {
                viewModel.setSelectedMovie(idData)
                viewModel.getMovie().observe(this, { detail ->
                    populateDataMovie(detail)
                })
            }
        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            viewModel.setSelectedTV(idData)
            idData.let {
                viewModel.getTV().observe(this, { detail ->
                    populateDataTv(detail)
                })
            }

        }


    }

    fun populateDataMovie(movie: DetailMovie?) {
        binding.tvTitle.text = movie!!.title
        binding.tvDesc.text = movie.overview
        binding.tvRealaseDate.text = movie.released
        binding.txtRating.text = movie.rating.toString().trim()
        var genreTxt = ""
        for (item in movie.genre!!) {
            genreTxt = item.name + ", " + genreTxt
        }
        binding.tvGenre.text = genreTxt
        setGlideImage(this@DetailActivity, movie.imgPoster, binding.imgItemPhoto)
        setGlideImage(this@DetailActivity, movie.imgBackground, binding.imgItemPreview)
    }

    fun populateDataTv(tv: DetailTvShow?) {
        binding.tvTitle.text = tv!!.title
        binding.tvDesc.text = tv.overview
        binding.tvRealaseDate.text = tv.firstAir
        binding.txtRating.text = tv.rating.toString().trim()
        var genreTxt = ""
        for (item in tv.genre!!) {
            genreTxt = item.name + ", " + genreTxt
        }
        binding.tvGenre.text = genreTxt
        setGlideImage(this@DetailActivity, tv.imgPoster, binding.imgItemPhoto)
        setGlideImage(this@DetailActivity, tv.imgBackground, binding.imgItemPreview)
    }
}