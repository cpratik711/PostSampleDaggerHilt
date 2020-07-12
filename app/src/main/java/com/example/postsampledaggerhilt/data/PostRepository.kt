package com.example.postsampledaggerhilt.data

import com.hellodiffa.dagger_hilt.data.remote.ApiHelper
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiHelper : ApiHelper) {
    suspend fun getPosts()= apiHelper.getPosts()
}