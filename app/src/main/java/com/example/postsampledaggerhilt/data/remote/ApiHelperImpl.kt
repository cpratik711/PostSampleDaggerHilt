package com.hellodiffa.dagger_hilt.data.remote

import com.example.postsampledaggerhilt.data.response.PostItem
import com.example.postsampledaggerhilt.data.response.PostResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val service: ApiService) : ApiHelper {
    override suspend fun getPosts(): Response<List<PostItem>> = service.getPosts()

}