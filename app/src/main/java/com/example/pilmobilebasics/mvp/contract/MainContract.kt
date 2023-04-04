package com.example.pilmobilebasics.mvp.contract

interface MainContract {
    interface Model {
        fun incNumber(inputNumber: Long)
        fun decNumber(inputNumber: Long)
        fun reset()
        fun getNumber(): Long
    }

    interface View {
        fun onIncButtonPressed(onClick: () -> Unit)
        fun onDecButtonPressed(onClick: () -> Unit)
        fun onResetButtonPressed(onClick: () -> Unit)
        fun getInputNumber(): String
        fun setNumber(addNumber: Long)
        fun showError()
        fun resetInputText()
    }

    interface Presenter {
        fun onIncButtonPressed()
        fun onDecButtonPressed()
        fun onResetButtonPressed()
    }
}
