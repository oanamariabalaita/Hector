package com.example.hector.ui.main.notifications.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hector.R
import com.example.hector.base.view.BaseFragment
import com.nightonke.boommenu.BoomButtons.HamButton
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : BaseFragment() {

    companion object {

        internal val TAG = "NotificationsFragment"

        fun newInstance(): NotificationsFragment {
            return NotificationsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //   presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
        initBoomMenu()
    }


    private fun initBoomMenu() {

        for (i in 0 until boom_menu.piecePlaceEnum.pieceNumber()) {
            var builder: HamButton.Builder = HamButton.Builder()
                .normalText("Butter Doesn't fly!")
                .normalColor(Color.LTGRAY)
                .textSize(13)
                .buttonWidth(480)
                .buttonHeight(150)

            Toast.makeText(context, "Clicked " + i, Toast.LENGTH_SHORT).show()
            boom_menu.addBuilder(builder)

        }
    }


    override fun setUp() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}