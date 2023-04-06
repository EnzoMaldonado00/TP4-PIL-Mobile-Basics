package com.example.pilmobilebasics.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.pilmobilebasics.R
import com.example.pilmobilebasics.databinding.ActivityMainBinding
import com.example.pilmobilebasics.mvp.contract.MainContract
import com.example.pilmobilebasics.mvp.view.base.ActivityView

class MainView(activity: Activity) : ActivityView(activity), MainContract.View {

    private val binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    override fun onIncButtonPressed(onClick: () -> Unit) {
        binding.btnIncrease.setOnClickListener { onClick() }
    }

    override fun onDecButtonPressed(onClick: () -> Unit) {
        binding.btnDecrease.setOnClickListener { onClick() }
    }

    override fun onResetButtonPressed(onClick: () -> Unit) {
        binding.btnReset.setOnClickListener { onClick() }
    }

    override fun getInputNumber(): String {
        return binding.inputValue.text.toString()
    }

    override fun setNumber(addNumber: Long) {
        binding.resultLabel.text = addNumber.toString()
    }

    override fun showError() {
        Toast.makeText(activity, R.string.error_message, Toast.LENGTH_SHORT).show()
    }

    override fun resetInputText() {
        Toast.makeText(activity, R.string.reset_message, Toast.LENGTH_SHORT).show()
    }

    override fun clear() {
        binding.inputValue.text.clear()
    }
}
