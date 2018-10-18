package com.example.jiadibo.footballmatchschedule.views.main.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                FirstFragment().apply {
                    mode = FirstFragment.Mode.PREVIOUS
                }
            }
            1 -> FirstFragment().apply {
                mode = FirstFragment.Mode.DEFAULT
            }
            else -> {
                return FirstFragment().apply {
                    mode = FirstFragment.Mode.FAVORITE
                }
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> {
                "Last Match"
            }

            1 -> {
                "Next Match"
            } else -> {
                return "Favorite"
            }
        }
    }
}