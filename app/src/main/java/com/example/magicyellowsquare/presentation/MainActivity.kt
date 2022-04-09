package com.example.magicyellowsquare.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.magicyellowsquare.R
import com.example.magicyellowsquare.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}