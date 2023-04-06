package com.example.pilmobilebasics.mvp.model

import com.example.pilmobilebasics.mvp.contract.MainContract

class MainModel : MainContract.Model {

    override var result = ZERO_LONG

    override fun incNumber(inputNumber: Long) {
        result += inputNumber
    }

    override fun decNumber(inputNumber: Long) {
        result -= inputNumber
    }

    override fun reset() {
        result = ZERO_LONG
    }

    override fun getNumber(): Long {
        return result
    }

    companion object {
        private const val ZERO_LONG: Long = 0
    }
}
