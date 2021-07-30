package com.noweto.newzk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.noweto.newzk.R
import dagger.hilt.android.AndroidEntryPoint

//~~ activity hold navigation component

@AndroidEntryPoint
class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

    }


}