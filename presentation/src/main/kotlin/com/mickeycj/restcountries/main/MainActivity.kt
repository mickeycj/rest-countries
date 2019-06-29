package com.mickeycj.restcountries.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mickeycj.restcountries.R

import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity for Main screens.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
    }
}
