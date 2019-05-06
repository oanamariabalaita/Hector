package com.example.hector.ui.main.dashboard.view

import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.hector.R
import com.example.hector.data.database.healthIndicators.HealthIndicator
import com.example.hector.ui.base.view.adapter.BaseRecyclerViewAdapter
import com.example.hector.ui.base.view.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_layout_health.view.*

class HealthCardAdapter: BaseRecyclerViewAdapter<HealthIndicator>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthIndicator> =
        HealthIndicatorsViewHolder(getViewHolderView(parent, R.layout.item_layout_health))


    override fun onBindViewHolder(holder: BaseViewHolder<HealthIndicator>, position: Int) {
        holder.itemView.startAnimation(
            AnimationUtils.loadAnimation(
            holder.itemView.context,
            R.anim.fall_down
        ))
        super.onBindViewHolder(holder, position)
    }

    class HealthIndicatorsViewHolder(itemView: View) : BaseViewHolder<HealthIndicator>(itemView) {
        override fun bind(item: HealthIndicator) {
            itemView.apply {
                tv_indicator_name.text = item.indicatorName
                tv_indicator_value.text = item.descriptiveVal
                item.imgId?.let {
                    img_icon.setImageResource(it)
                }
            }
        }
    }

}