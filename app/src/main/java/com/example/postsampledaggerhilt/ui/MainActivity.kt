package com.example.postsampledaggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsampledaggerhilt.R
import com.example.postsampledaggerhilt.common.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        postViewModel.news.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    val postItems = it.data!!.toList()
                    val postAdapter = PostAdapter(postItems)
                    recyclerView.adapter = postAdapter
                }
                Status.ERROR -> {
                    it.message

                }
                Status.LOADING -> {

                }
            }
        })

    }
}