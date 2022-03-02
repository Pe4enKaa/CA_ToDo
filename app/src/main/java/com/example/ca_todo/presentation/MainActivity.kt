package com.example.ca_todo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ca_todo.R

class MainActivity : AppCompatActivity() {

    private var count = 0;

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.shopList.observe(this) {
            Log.e("TAG", it.toString())
            if (count == 0) {
                count++
                val item = it[0]
                viewModel.changeEnabledState(item)
            }
        }
    }
}