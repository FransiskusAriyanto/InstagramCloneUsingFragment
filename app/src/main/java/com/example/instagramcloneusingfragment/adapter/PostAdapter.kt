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

class PostAdapter (var context: Context, var dataset: List<MyModel>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imagePost = view.findViewById<ImageView>(R.id.post_image)
        var imageProfile = view.findViewById<ImageView>(R.id.profile_image_post)
        var imageProfileBottom = view.findViewById<ImageView>(R.id.profile_image_post_bottom)
        var accountName = view.findViewById<TextView>(R.id.account_name_post_top)
        var postCaption = view.findViewById<TextView>(R.id.post_caption)
        var accountNameBottom = view.findViewById<TextView>(R.id.account_name_post_bottom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_post, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Glide.with(context).load(dataset[position].image).into(holder.imagePost)
        Glide.with(context).load(dataset[position].image).into(holder.imageProfile)
        Glide.with(context).load(dataset[position].image).into(holder.imageProfileBottom)
        holder.accountName.text = dataset[position].name
        holder.accountNameBottom.text = dataset[position].name
        holder.postCaption.text = dataset[position].actor
    }

}