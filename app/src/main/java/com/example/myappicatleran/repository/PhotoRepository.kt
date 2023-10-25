package com.example.myappicatleran.repository

import com.example.myappicatleran.api.ApiService
import com.example.myappicatleran.model.Photo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRepository {

    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/") // Replace with your API base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getPhotos(): Call<List<Photo>> {
        return apiService.getPhotos()
    }

}