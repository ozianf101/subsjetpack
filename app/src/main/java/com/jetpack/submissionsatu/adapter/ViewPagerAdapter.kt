package com.jetpack.submissionsatu.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jetpack.submissionsatu.fragment.MoviesFragment
import com.jetpack.submissionsatu.fragment.TvShowFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {


    private val listFragment = arrayOf(
        MoviesFragment(),
        TvShowFragment()
    )

    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment = listFragment[position] as Fragment


}