package com.example.pilmobilebasics

import com.example.pilmobilebasics.mvp.contract.MainContract
import com.example.pilmobilebasics.mvp.model.MainModel
import com.example.pilmobilebasics.mvp.presenter.MainPresenter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var mainPresenter: MainContract.Presenter

    @RelaxedMockK
    private lateinit var mainModel: MainContract.Model

    @RelaxedMockK
    private lateinit var mainView: MainContract.View

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        mainModel = MainModel()
        mainPresenter = MainPresenter(mainModel, mainView)
    }

    @Test
    fun `on inc btn pressed should increment the value`() {
        val number = "14"
        every { mainView.getInputNumber() } returns number
        mainPresenter.onIncButtonPressed()
        verify { mainView.setNumber(number.toLong()) }
    }

    @Test
    fun `inc btn pressed without a value entered should show an error message`() {
        val emptyInput = ""
        every { mainView.getInputNumber() } returns emptyInput
        mainPresenter.onIncButtonPressed()
        verify { mainView.showError() }
    }

    @Test
    fun `on dec btn pressed should decrement the value`() {
        val number = "14"
        every { mainView.getInputNumber() } returns number
        mainPresenter.onDecButtonPressed()
        verify { mainView.setNumber(-14L) }
    }

    @Test
    fun `on dec btn pressed without a value entered should show an error message`() {
        val emptyInput = ""
        every { mainView.getInputNumber() } returns emptyInput
        mainPresenter.onDecButtonPressed()
        verify { mainView.showError() }
    }

    @Test
    fun `on reset btn pressed the counter should reset to 0`() {
        val number = 0L
        mainPresenter.onResetButtonPressed()
        verify { mainView.resetInputText() }
        verify { mainView.setNumber(number) }
    }
}
