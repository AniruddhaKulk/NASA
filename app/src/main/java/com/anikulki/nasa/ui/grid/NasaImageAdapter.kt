package com.anikulki.nasa.ui.grid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anikulki.nasa.databinding.ItemNasaImageBinding
import com.anikulki.nasa.model.NASAImagesItem
import com.bumptech.glide.Glide

class NasaImageAdapter(private val list: MutableList<NASAImagesItem>,
                       private val listener: OnItemClickListener): RecyclerView.Adapter<NasaImageAdapter.ImageHolder>(){

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val binding = ItemNasaImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val image = list[position]
        holder.bind(image)
    }

    fun setData(data: List<NASAImagesItem>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class ImageHolder(private val binding: ItemNasaImageBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    listener.onImageClick(position)
                }
            }
        }

        fun bind(image: NASAImagesItem?){
            image?.let {
                Glide.with(itemView.context)
                    .load(image.url)
                    .centerCrop()
                    .into(binding.ivNasa)
            }
        }
    }

    interface OnItemClickListener{
        fun onImageClick(position: Int)
    }
}