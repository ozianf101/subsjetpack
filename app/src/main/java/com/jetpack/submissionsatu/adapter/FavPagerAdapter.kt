package com.jetpack.submissionsatu.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jetpack.submissionsatu.fragment.MovieFavFragment
import com.jetpack.submissionsatu.fragment.TvShowFavFragment

class FavPagerAdapter(appCompatActivity: AppCompatActivity) :
    FragmentStateAdapter(appCompatActivity) {

    private val listFragment = arrayOf(
        MovieFavFragment(),
        TvShowFavFragment()
    )

    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment = listFragment[position]
}