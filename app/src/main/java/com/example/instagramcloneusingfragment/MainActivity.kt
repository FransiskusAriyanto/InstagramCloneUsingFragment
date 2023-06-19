package com.example.instagramcloneusingfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcloneusingfragment.adapter.PostAdapter
import com.example.instagramcloneusingfragment.adapter.StoryAdapter
import com.example.instagramcloneusingfragment.model.IModel
import com.example.instagramcloneusingfragment.model.MyModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewStory: RecyclerView
    lateinit var postAdapter: PostAdapter
    lateinit var storyAdapter: StoryAdapter

    var baseUrl = "https://hp-api.onrender.com/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewStory = findViewById(R.id.recycler_view_story)
        recyclerView = findViewById(R.id.recycler_view_post)

        getAllPost()
        getAllStory()
    }

    private fun getAllPost() {
        var retrofitPost = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IModel::class.java)

        var retrofitPostData = retrofitPost.getPostData()

        retrofitPostData.enqueue(object : Callback<List<MyModel>> {
            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                var data = response.body()!!
                postAdapter = PostAdapter(baseContext, data)
                recyclerView.adapter = postAdapter
            }

            override fun onFailure(call: Call<List<MyModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun getAllStory() {
        var retrofitStory = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IModel::class.java)

        var retrofitStoryData = retrofitStory.getPostData()

        retrofitStoryData.enqueue(object : Callback<List<MyModel>>{
            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                var data = response.body()!!
                storyAdapter = StoryAdapter(baseContext, data)
                recyclerViewStory.adapter = storyAdapter
            }

            override fun onFailure(call: Call<List<MyModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}