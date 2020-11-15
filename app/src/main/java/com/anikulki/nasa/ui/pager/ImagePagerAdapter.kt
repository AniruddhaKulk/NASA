package com.anikulki.nasa.ui.pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anikulki.nasa.databinding.ItemImagePagerBinding
import com.anikulki.nasa.model.NASAImagesItem
import com.bumptech.glide.Glide

class ImagePagerAdapter (private val list: MutableList<NASAImagesItem>) :
    RecyclerView.Adapter<ImagePagerAdapter.PagerViewHolder>() {


    override fun getItemCount() = list.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding = ItemImagePagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun setData(data: List<NASAImagesItem>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class PagerViewHolder(private val binding: ItemImagePagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NASAImagesItem) {
            Glide.with(itemView.context)
                .load(item.url)
                .centerCrop()
                .into(binding.ivNasaImage)

            binding.tvTitle.text = item.title

            binding.tvDescription.text = item.explanation
        }
    }
}