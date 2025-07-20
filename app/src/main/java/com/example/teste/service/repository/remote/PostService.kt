package com.example.teste.service.repository.remote

import com.example.teste.entity.PostEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface PostService {
    @GET("posts")
    fun listCall(): Call<List<PostEntity>>
}