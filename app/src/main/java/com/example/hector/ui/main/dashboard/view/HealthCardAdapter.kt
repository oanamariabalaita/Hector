package com.example.hector.ui.main.dashboard.view

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.hector.R
import com.example.hector.data.database.healthIndicators.HealthIndicator
import com.example.hector.ui.base.view.adapter.BaseRecyclerViewAdapter
import com.example.hector.ui.base.view.adapter.BaseViewHolder
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.item_layout_health.view.*

class HealthCardAdapter : BaseRecyclerViewAdapter<HealthIndicator>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthIndicator> =
        HealthIndicatorsViewHolder(getViewHolderView(parent, R.layout.item_layout_health))


    override fun onBindViewHolder(holder: BaseViewHolder<HealthIndicator>, position: Int) {
        holder.itemView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.itemView.context,
                R.anim.fall_down
            )
        )

        super.onBindViewHolder(holder, position)
    }

    class HealthIndicatorsViewHolder(itemView: View) : BaseViewHolder<HealthIndicator>(itemView) {
        override fun bind(item: HealthIndicator) {
            itemView.apply {
                item.imgId?.let {
                    img_icon.setImageResource(it)
                    txt_title.text = item.indicatorName
                    last_value.text = item.quantitativeVal.toString()
                    last_value_unit.text = item.unit
//                    if(txt_title.equals("Sleep")){
//                        var b : Drawable = bullet_status.background
//                        var c : ShapeDrawable = background as ShapeDrawable
//                        c.paint.color=ContextCompat.getColor(itemView.context,R.color.red_dark)
//                    }
                    initChart(this)
                }
            }
        }

        private fun initChart(view: View) {

            var chart_card = view.chart_card

            chart_card.description.isEnabled = false
            chart_card.setTouchEnabled(false)
            // set listeners
            chart_card.setDrawGridBackground(false)

            val values = ArrayList<Entry>()

            for (i in 1 until 8) {

                val a = (Math.random() * 2).toFloat()
                values.add(Entry(i.toFloat(), a, ContextCompat.getDrawable(context, R.drawable.icon_home)))
            }

            var set1: LineDataSet

            if (chart_card.data != null &&
                chart_card.data.getDataSetCount() > 0
            ) {
                set1 = chart_card.getData().getDataSetByIndex(0) as LineDataSet
                set1.setValues(values)
                set1.notifyDataSetChanged()
                chart_card.getData().notifyDataChanged()
                chart_card.notifyDataSetChanged()
            } else {

                set1 = LineDataSet(values, "Weekly DataSet")
                set1.setDrawIcons(false)
                set1.enableDashedLine(10f, 5f, 0f)
                set1.color = Color.GRAY
                set1.setCircleColor(Color.rgb(255, 140, 0))
                set1.lineWidth = 1f
                set1.circleRadius = 3f
                set1.setDrawCircleHole(false)

                // customize legend entry
                set1.formLineWidth = 0f

                // text size of values
                set1.valueTextSize = 4f

                chart_card.axisRight.isEnabled = false
                chart_card.axisLeft.isEnabled = false

                val dataSets = ArrayList<ILineDataSet>()
                dataSets.add(set1)
                val data = LineData(dataSets)
                chart_card.data = data
            }

        }
    }

}