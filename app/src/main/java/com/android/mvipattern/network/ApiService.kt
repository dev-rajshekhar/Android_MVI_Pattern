package com.android.mvipattern.network

import retrofit2.http.GET

interface  ApiService{
    @GET("blogs")
    suspend fun  getBlogs():List<BlogNetworkEntity>


}