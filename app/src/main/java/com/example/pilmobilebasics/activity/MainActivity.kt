package com.example.pilmobilebasics.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pilmobilebasics.mvp.model.MainModel
import com.example.pilmobilebasics.mvp.presenter.MainPresenter
import com.example.pilmobilebasics.mvp.view.MainView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainPresenter(MainModel(), MainView(this))
    }
}
