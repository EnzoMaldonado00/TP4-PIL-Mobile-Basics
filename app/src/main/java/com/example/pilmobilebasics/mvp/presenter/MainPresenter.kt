package com.example.pilmobilebasics.mvp.presenter

import com.example.pilmobilebasics.mvp.contract.MainContract

class MainPresenter(private val model: MainContract.Model, private val view: MainContract.View) : MainContract.Presenter {

    init {
        view.onIncButtonPressed { onIncButtonPressed() }
        view.onDecButtonPressed { onDecButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }
        view.setNumber(model.result)
    }

    override fun onIncButtonPressed() {
        if (view.getInputNumber().isEmpty()) {
            view.showError()
        } else {
            val number = view.getInputNumber().toLong()
            model.incNumber(number)
            view.setNumber(model.getNumber())
        }
    }

    override fun onDecButtonPressed() {
        if (view.getInputNumber().isEmpty()) {
            view.showError()
        } else {
            model.decNumber(view.getInputNumber().toLong())
            view.setNumber(model.getNumber())
        }
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.clear()
        view.resetInputText()
        view.setNumber(model.getNumber())
    }
}
