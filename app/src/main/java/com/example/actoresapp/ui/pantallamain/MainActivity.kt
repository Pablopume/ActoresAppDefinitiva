package com.example.actoresapp.ui.pantallamain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.namespace.R
import com.example.namespace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}