package com.hellodiffa.dagger_hilt.data.remote

import com.example.postsampledaggerhilt.data.response.PostItem
import com.example.postsampledaggerhilt.data.response.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<List<PostItem>>

}