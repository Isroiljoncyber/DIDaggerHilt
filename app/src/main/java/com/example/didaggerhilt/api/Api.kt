package com.example.didaggerhilt.api

import com.example.didaggerhilt.model.GalleryModel
import com.example.didaggerhilt.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("posts")
    fun getPost(): Call<List<PostModel>>

    @GET("photos")
    fun getPhotos() : Call<List<GalleryModel>>

}