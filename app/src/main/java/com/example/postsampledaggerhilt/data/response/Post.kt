package com.example.postsampledaggerhilt.data.response



class PostResponse : ArrayList<PostItem>()

data class PostItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)