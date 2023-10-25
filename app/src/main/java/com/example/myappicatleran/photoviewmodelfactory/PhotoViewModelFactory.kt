package com.example.myappicatleran.photoviewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myappicatleran.viewmodel.PhotoViewModel

class PhotoViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(PhotoViewModel::class.java)){
          return PhotoViewModel() as T
      }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}