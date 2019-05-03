package com.example.hector.utils.extensions

import android.content.Context
import android.view.Gravity
import android.widget.Toast

internal fun Context.toast(message: CharSequence) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.BOTTOM, 0, 600)
    toast.show()
}