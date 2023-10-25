package com.example.myappicatleran.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappicatleran.R
import com.example.myappicatleran.model.Photo

class PhotoAdapter(private var photos:List<Photo>):RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.photoTitle)
        val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
        // Add references to other views here.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.titleTextView.text = photo.title
        Glide.with(holder.itemView.context)
            .load(photo.thumbnailUrl) // Replace "photo.url" with the actual image URL.
            .into(holder.photoImageView)
        // Bind other data to views here.
    }

    override fun getItemCount(): Int {
        return photos.size
    }
    fun updateData(newPhotos: List<Photo>) {
        photos = newPhotos
        notifyDataSetChanged()
    }
}