package com.example.teste.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teste.databinding.ItemPostsBinding
import com.example.teste.entity.PostEntity
import com.example.teste.ui.viewholder.PostsViewHolder

class PostsAdapter : RecyclerView.Adapter<PostsViewHolder>(){

    private var postList: List<PostEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    fun updatePosts(list: List<PostEntity>) {
        postList = list
        notifyDataSetChanged()
    }

}

