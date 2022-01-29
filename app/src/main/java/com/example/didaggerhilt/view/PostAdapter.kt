package com.example.didaggerhilt.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.didaggerhilt.databinding.PostItemLayoutBinding
import com.example.didaggerhilt.model.PostModel

class PostAdapter(val items: List<PostModel>) : RecyclerView.Adapter<PostAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: PostItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            PostItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvBody.text = item.body
    }

    override fun getItemCount(): Int = items.count()
}