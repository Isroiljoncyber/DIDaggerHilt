package com.example.didaggerhilt.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.didaggerhilt.databinding.PhotoItemLayoutBinding
import com.example.didaggerhilt.model.GalleryModel
import com.squareup.picasso.Picasso

class PhotoAdapter(var items: List<GalleryModel>) :
    RecyclerView.Adapter<PhotoAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: PhotoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            PhotoItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        Picasso.get().load(item.url).into(holder.binding.imgView)
    }

    override fun getItemCount(): Int = items.count()

}