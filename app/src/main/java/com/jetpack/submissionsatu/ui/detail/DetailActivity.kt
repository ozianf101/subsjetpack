package com.jetpack.submissionsatu.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.data.Helper.TYPE_MOVIE
import com.jetpack.submissionsatu.data.Helper.TYPE_TVSHOW
import com.jetpack.submissionsatu.data.Helper.setGlideImage
import com.jetpack.submissionsatu.databinding.ActivityDetailBinding
import com.jetpack.submissionsatu.model.DataEntitas

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater)}
    private lateinit var result: DataEntitas

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val idData = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            idData?.let {
                viewModel.setSelectedMovie(it)
            }
            result = viewModel.getMovie()
        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            idData?.let {
                viewModel.setSelectedTV(it)
            }
            result = viewModel.getTV()
        }

        binding.tvTitle.text = result.title
        binding.tvDesc.text = result.overview
        binding.tvRealaseDate.text = result.released
        binding.tvGenre.text = result.genre
        binding.txtRating.text = result.rating.toString().trim()
        setGlideImage(this@DetailActivity, result.imgPoster, binding.imgItemPhoto)
        setGlideImage(this@DetailActivity, result.imgBackground, binding.imgItemPreview)
    }

}