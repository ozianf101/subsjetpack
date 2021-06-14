package com.jetpack.submissionsatu.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.adapter.FavPagerAdapter
import com.jetpack.submissionsatu.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFavoriteBinding.inflate(layoutInflater) }

    private val tabTitle = intArrayOf(
        R.string.movies,
        R.string.tvshow
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tab = binding.tabsFav
        val pager = binding.vpFavorite
        pager.adapter = FavPagerAdapter(this)

        TabLayoutMediator(tab, pager) { tb, pos ->
            tb.text = resources.getString(tabTitle[pos])
        }.attach()

        binding.tbFavorite.setNavigationIcon(R.drawable.ic_back)
        setSupportActionBar(binding.tbFavorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tbFavorite.setNavigationOnClickListener {
            finish()
        }

    }
}