package com.example.pilmobilebasics.mvp.model

import com.example.pilmobilebasics.mvp.contract.MainContract
import com.example.pilmobilebasics.util.Constants.Companion.ZERO

class MainModel : MainContract.Model {

    private var result = ZERO

    override fun incNumber(inputNumber: Long) {
        result += inputNumber
    }

    override fun decNumber(inputNumber: Long) {
        result -= inputNumber
    }

    override fun reset() {
        result = ZERO
    }

    override fun getNumber(): Long {
        return result
    }
}
