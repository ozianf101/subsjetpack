package com.jetpack.submissionsatu.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.tabs.TabLayoutMediator
import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.adapter.ViewPagerAdapter
import com.jetpack.submissionsatu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private val tabTitle = intArrayOf(
        R.string.movies,
        R.string.tvshow
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.latar_gotham, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.latar_cold_persuit, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.latar_t34, ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.latar_a_star, ScaleTypes.CENTER_CROP))

        val imageSlider = activityMainBinding.carouselView
        imageSlider.setImageList(imageList)

        setSupportActionBar(activityMainBinding.toolBar)
        supportActionBar?.elevation = 0f

        val tab = activityMainBinding.tabs
        val vPager = activityMainBinding.viewPager
        vPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tab, vPager) { tab, position ->
            tab.text = resources.getString(tabTitle[position])
        }.attach()
    }

}