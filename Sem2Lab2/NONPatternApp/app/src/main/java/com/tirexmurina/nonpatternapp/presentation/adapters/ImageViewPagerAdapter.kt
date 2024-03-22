package com.tirexmurina.nonpatternapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tirexmurina.nonpatternapp.R
import com.tirexmurina.nonpatternapp.databinding.ItemDetailsImageBinding

class ImageViewPagerAdapter() : RecyclerView.Adapter<ImageViewHolder>() {

    var pics: List<String> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
            // знаю что все надо было на DiffUtil сделать, не успел
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDetailsImageBinding.inflate(inflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int = pics.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(pics[position])
    }

}

class ImageViewHolder(
    private val binding: ItemDetailsImageBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(picture: String) {
        with(binding){
            Glide.with(sliderItem.context)
                .load(picture)
                .placeholder(R.drawable.ic_recycler_view_placeholder)
                .error(R.drawable.ic_recycler_view_placeholder)
                .into(sliderItem)
        }
    }

}