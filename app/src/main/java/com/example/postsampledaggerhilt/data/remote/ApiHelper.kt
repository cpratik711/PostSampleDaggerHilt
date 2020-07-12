package com.hellodiffa.dagger_hilt.data.remote

import com.example.postsampledaggerhilt.data.response.PostItem
import com.example.postsampledaggerhilt.data.response.PostResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getPosts(): Response<List<PostItem>>
}