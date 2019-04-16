package com.example.hector.ui.base.presenter

import com.example.hector.ui.base.interactor.MVPInteractor
import com.example.hector.ui.base.view.MVPView

interface MVPPresenter < V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}