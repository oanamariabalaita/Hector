package com.example.hector.ui.main.dashboard.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.example.hector.R
import com.example.hector.data.local.indicator.HealthIndicator
import com.example.hector.design.LineChartMarkerView
import com.example.hector.base.view.adapter.BaseRecyclerViewAdapter
import com.example.hector.base.view.adapter.BaseViewHolder
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.item_layout_health.view.*
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

class HealthCardAdapter : BaseRecyclerViewAdapter<HealthIndicator>(), OnChartValueSelectedListener {

    override fun onNothingSelected() {
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
    }

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
                    img_icon.setImageResource(it.toInt())
                    txt_title.text = item.indicatorName
                    last_value.text = item.quantitativeVal.toString()
                    last_value_unit.text = item.unit
                    if (item.indicatorName == "Sleep") {
                        val b: Drawable = bullet_status.background
                        val c: GradientDrawable = b as GradientDrawable
                        c.mutate()
                        c.setColor(ContextCompat.getColor(itemView.context, R.color.red_dark))
                    }
                    initChart(this)
                    chart_card.setOnChartValueSelectedListener(itemView.context)
                }
            }
        }

        private fun initChart(view: View) {

            val chart_card = view.chart_card
            chart_card.description.isEnabled = false
            chart_card.setTouchEnabled(true)
            chart_card.setDrawGridBackground(false)
            chart_card.animateY(2000)

            val mv = LineChartMarkerView(context, R.layout.custom_marker_view)
            mv.chartView = chart_card
            chart_card.marker = mv

            val xLabel = ArrayList<String>()
            xLabel.add("")
            xLabel.add("M")
            xLabel.add("T")
            xLabel.add("W")
            xLabel.add("T")
            xLabel.add("F")
            xLabel.add("S")
            xLabel.add("S")

            val values = ArrayList<Entry>()

            for (i in 1 until 8) {

                val a = (Math.random() * 2).toFloat() + 5
                values.add(Entry(i.toFloat(), a))
            }

            val set1: LineDataSet

            if (chart_card.data != null &&
                chart_card.data.dataSetCount > 0
            ) {
                set1 = chart_card.data.getDataSetByIndex(0) as LineDataSet
                set1.values = values
                set1.notifyDataSetChanged()
                chart_card.data.notifyDataChanged()
                chart_card.notifyDataSetChanged()

            } else {

                val xAxis: XAxis = chart_card.xAxis
                val formatter: IndexAxisValueFormatter = object : IndexAxisValueFormatter() {

                    override fun getFormattedValue(value: Float): String{
                        return xLabel[value.toInt()]
                    }
                }

                set1 = LineDataSet(values, "Weekly dataset")

                set1.setDrawIcons(false)
                set1.enableDashedLine(10f, 5f, 0f)
                set1.color = Color.GRAY
                set1.setCircleColor(Color.rgb(255, 140, 0))
                set1.lineWidth = 1f
                set1.circleRadius = 3f
                set1.setDrawCircleHole(false)
                set1.valueTextSize = 7f
                set1.setDrawValues(false)
                xAxis.position = XAxis.XAxisPosition.TOP
                xAxis.granularity = 1f
                chart_card.axisRight.isEnabled = false
                chart_card.axisLeft.isEnabled = false

                val dataSets = ArrayList<ILineDataSet>()
                dataSets.add(set1)

                val data = LineData(dataSets)
                chart_card.setData(data)
                xAxis.valueFormatter = formatter
                chart_card.invalidate()
            }
        }
    }

}

private fun LineChart.setOnChartValueSelectedListener(context: Context?) {

}
