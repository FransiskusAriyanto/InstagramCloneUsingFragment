package com.example.instagramcloneusingfragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramcloneusingfragment.R
import com.example.instagramcloneusingfragment.model.MyModel

class StoryAdapter(var context: Context, var dataset: List<MyModel>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView = view.findViewById<ImageView>(R.id.profile_image_story)
        var textView = view.findViewById<TextView>(R.id.list_account_story)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_story, parent, false)
        return StoryViewHolder(itemView)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        Glide.with(context).load(dataset[position].image).into(holder.imageView)
        holder.textView.text = dataset[position].name
    }

}