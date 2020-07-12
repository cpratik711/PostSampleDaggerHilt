package com.example.postsampledaggerhilt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.postsampledaggerhilt.R
import com.example.postsampledaggerhilt.data.response.PostItem
import kotlinx.android.synthetic.main.row_post.view.*

class PostAdapter constructor(private val items: List<PostItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //    private var items: List<PostItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_post, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).bind(items.get(position))
    }

    class PostViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.tvTitle
        val userId = itemView.tvUserId
        val body = itemView.tvBody

        fun bind(postItem: PostItem) {
            userId.text = postItem.userId.toString()
            title.text = postItem.title
            body.text = postItem.body
        }
    }
}