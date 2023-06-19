package com.example.instagramcloneusingfragment.model

import retrofit2.Call
import retrofit2.http.GET

interface IModel {
    @GET("characters")
    fun getPostData() : Call<List<MyModel>>
}