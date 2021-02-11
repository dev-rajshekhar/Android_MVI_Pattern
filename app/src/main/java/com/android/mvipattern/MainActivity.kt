package com.android.mvipattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mvipattern.databinding.ActivityMainBinding
import com.android.mvipattern.utility.DataState
import com.android.mvipattern.viewmodel.BlogVm
import com.android.mvipattern.viewmodel.MainStateEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val blogVm: BlogVm by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: BlogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = BlogAdapter()
        binding.apply {
            recyclerViewBlog.adapter= adapter
            recyclerViewBlog.layoutManager = LinearLayoutManager(this@MainActivity)

        }


        blogVm.dataState.observe(this, Observer { dataState ->

            when (dataState) {
                is DataState.Success -> {
                    displayProgressBar(false)
                    adapter.submitList(dataState.data)

                }

                is DataState.Error -> {
                    displayProgressBar(false)

                    Log.e(TAG, "Error: ", dataState.exception)
                }
                DataState.Loading -> {
                    displayProgressBar(true)

                }
            }
        })

        blogVm.setStateEvent(MainStateEvent.GetBlogEvent)

    }

    private fun displayError(message: String?) {

    }

    private fun displayData(message: String?) {

    }


    private fun displayProgressBar(showProgressBar: Boolean) {
        binding.progressBar.isVisible = showProgressBar

    }


}