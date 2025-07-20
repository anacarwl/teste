package com.example.teste.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.teste.databinding.ItemPostsBinding
import com.example.teste.entity.PostEntity

class PostsViewHolder ( private val item: ItemPostsBinding): RecyclerView.ViewHolder(item.root) {
    fun bind(post: PostEntity){
        item.textviewTitle.text = post.title
        item.textviewBody.text = post.body
        item.textviewId.text = post.id.toString();

    }

}