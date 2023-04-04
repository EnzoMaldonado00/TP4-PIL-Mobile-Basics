package com.example.pilmobilebasics

import com.example.pilmobilebasics.mvp.contract.MainContract
import com.example.pilmobilebasics.mvp.model.MainModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainModelTest {
    private lateinit var mainModel: MainContract.Model

    @Before
    fun setup() {
        mainModel = MainModel()
    }

    @Test
    fun incTest() {
        val number = 14L
        mainModel.incNumber(number)
        Assert.assertEquals(14L, number)
    }

    @Test
    fun decTest() {
        val number = 0 - 14L
        mainModel.decNumber(number)
        Assert.assertEquals(-14L, number)
    }

    @Test
    fun resetTest() {
        val number = 0
        mainModel.reset()
        Assert.assertEquals(0, number)
    }

    @Test
    fun getTest() {
        val number = 14L
        mainModel.incNumber(number)
        mainModel.getNumber()
        Assert.assertEquals(14L, number)
    }
}
