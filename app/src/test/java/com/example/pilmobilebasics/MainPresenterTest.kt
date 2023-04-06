package com.example.pilmobilebasics

import com.example.pilmobilebasics.mvp.contract.MainContract
import com.example.pilmobilebasics.mvp.model.MainModel
import com.example.pilmobilebasics.mvp.presenter.MainPresenter
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var mainPresenter: MainContract.Presenter

    private var mainView: MainContract.View = mockk(relaxed = true)

    @Before
    fun setup() {
        mainPresenter = MainPresenter(MainModel(), mainView)
        verify { mainView.onIncButtonPressed(any()) }
        verify { mainView.onDecButtonPressed(any()) }
        verify { mainView.onResetButtonPressed(any()) }
        verify { mainView.setNumber(ZERO_LONG) }
    }

    @Test
    fun `on inc btn pressed should increment the value`() {
        val number = FOURTEEN_STRING
        every { mainView.getInputNumber() } returns number
        mainPresenter.onIncButtonPressed()
        verify { mainView.setNumber(number.toLong()) }
    }

    @Test
    fun `inc btn pressed without a value entered should show an error message`() {
        val emptyInput = EMPTY_STRING
        every { mainView.getInputNumber() } returns emptyInput
        mainPresenter.onIncButtonPressed()
        verify { mainView.showError() }
    }

    @Test
    fun `on dec btn pressed should decrement the value`() {
        val number = FOURTEEN_STRING
        every { mainView.getInputNumber() } returns number
        mainPresenter.onDecButtonPressed()
        verify { mainView.setNumber(-14L) }
    }

    @Test
    fun `on dec btn pressed without a value entered should show an error message`() {
        val emptyInput = EMPTY_STRING
        every { mainView.getInputNumber() } returns emptyInput
        mainPresenter.onDecButtonPressed()
        verify { mainView.showError() }
    }

    @Test
    fun `on reset btn pressed the counter should reset to 0`() {
        val number = ZERO_LONG
        mainPresenter.onResetButtonPressed()
        verify { mainView.resetInputText() }
        verify { mainView.setNumber(number) }
    }

    companion object {
        private const val ZERO_LONG: Long = 0
        private const val EMPTY_STRING = ""
        private const val FOURTEEN_STRING = "14"
    }
}
