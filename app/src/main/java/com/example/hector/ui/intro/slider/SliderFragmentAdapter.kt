package com.example.hector.ui.intro.slider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.hector.ui.intro.slider.slidefour.view.SlideFourFragment
import com.example.hector.ui.intro.slider.slideone.view.SlideOneFragment
import com.example.hector.ui.intro.slider.slidethree.view.SlideThreeFragment
import com.example.hector.ui.intro.slider.slidetwo.view.SlideTwoFragment

class SliderFragmentAdapter constructor(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    var slideCount = 4

    override fun getItem(position: Int): Fragment {

        return when (position) {

            0 -> SlideOneFragment.newInstance()
            1 -> SlideTwoFragment.newInstance()
            2 -> SlideThreeFragment.newInstance()
            3 -> SlideFourFragment.newInstance()
            else -> SlideOneFragment.newInstance()
        }

    }

    internal fun setCount(count: Int) {
        this.slideCount = count
    }

    override fun getCount(): Int {
           return slideCount
        }
    }