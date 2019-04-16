package com.example.hector.ui.intro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.hector.R
import com.example.hector.ui.base.view.BaseActivity
import com.example.hector.ui.intro.slider.SliderFragmentAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_intro.*
import javax.inject.Inject


class IntroActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    internal lateinit var slidePagerAdapter: FragmentStatePagerAdapter
    private lateinit var mPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        mPager = findViewById(R.id.view_pager)
        slidePagerAdapter = SliderFragmentAdapter(supportFragmentManager)
        setUpSliderPagerAdapter()
    }
    override fun supportFragmentInjector(): AndroidInjector<Fragment>?{
        return fragmentDispatchingAndroidInjector
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    private fun setUpSliderPagerAdapter(){
       // slidePagerAdapter.count= 4
        mPager.adapter = slidePagerAdapter


    }
}