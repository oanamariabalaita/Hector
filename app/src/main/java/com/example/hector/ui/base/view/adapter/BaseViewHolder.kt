package com.example.hector.ui.base.view.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract  class BaseViewHolder<out T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: @UnsafeVariance T)

    val context: Context = itemView.context

    fun getString(resId: Int, vararg formatArgs: Any? = emptyArray()): String {
        return context.getString(resId, formatArgs)
    }
}