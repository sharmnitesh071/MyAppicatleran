package com.example.myappicatleran.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myappicatleran.model.Photo
import com.example.myappicatleran.repository.PhotoRepository
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class PhotoViewModel : ViewModel() {
    private val photos = MutableLiveData<List<Photo>>()
    private val photoRepository = PhotoRepository()

    init {
        fetchPhotos()
    }


    fun getPhotos(): LiveData<List<Photo>> {
        return photos
    }


    private fun fetchPhotos() {
       photoRepository.getPhotos().enqueue(object : retrofit2.Callback<List<Photo>> {
           override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
              if (response.isSuccessful){
                  photos.value=response.body()
              }
           }

           override fun onFailure(call: Call<List<Photo>>, t: Throwable) {

           }

       })
    }
}