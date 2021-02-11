package com.android.mvipattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.android.mvipattern.databinding.ActivityMainBinding
import com.android.mvipattern.utility.DataState
import com.android.mvipattern.viewmodel.BlogVm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val blogVm: BlogVm by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        blogVm.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success -> {
                    println("====Success")

                }

                is DataState.Error -> {
                    println("====Error")

                }
                DataState.Loading -> {
                    println("====Loading")
                }
            }
        })

    }

    private fun displayError(message: String?) {

    }

    private fun displayData(message: String?) {

    }


    private fun displayProgressBar(message: String?) {

    }


}