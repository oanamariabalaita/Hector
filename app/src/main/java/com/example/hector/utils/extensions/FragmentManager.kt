package com.example.hector.utils.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.hector.R
import com.example.hector.ui.base.view.BaseFragment

internal fun FragmentManager.removeFragment(
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    this.beginTransaction()
        .disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .remove(this.findFragmentByTag(tag)!!)
        .commitNow()
}

internal fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right
) {
    this.beginTransaction().disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .add(containerViewId, fragment, tag)
        .commit()
}


internal fun FragmentManager.replaceFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String,
    slideIn: Int = R.anim.slide_left,
    slideOut: Int = R.anim.slide_right) {

    this.beginTransaction()
    .setCustomAnimations(slideIn, slideOut)
    .replace(containerViewId, fragment, fragment.tag)
    .addToBackStack(null)
    .commit()
}

