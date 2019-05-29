package com.example.hector.base.presenter

import com.example.hector.base.interactor.MVPInteractor
import com.example.hector.base.view.MVPView

interface MVPPresenter < V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getViewDem(): V?
}