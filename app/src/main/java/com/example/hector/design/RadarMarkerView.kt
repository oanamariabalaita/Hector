package com.example.hector.design

import android.content.Context
import android.graphics.Typeface
import com.example.hector.R
import com.github.mikephil.charting.components.MarkerView
import kotlinx.android.synthetic.main.radar_markerview.view.*
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight

@SuppressWarnings("MagicNumber")
class RadarMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    init {
        tvContent.typeface = Typeface.createFromAsset(context.assets, "OpenSans-Light.ttf")
    }

    override fun refreshContent(e: Entry, highlight: Highlight) {

        tvContent.text = String.format("%s %%", e.y)
        // format.format(e.getY()))
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height - 10).toFloat())
    }


}