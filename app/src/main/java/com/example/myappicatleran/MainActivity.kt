package com.example.myappicatleran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappicatleran.adapter.PhotoAdapter
import com.example.myappicatleran.photoviewmodelfactory.PhotoViewModelFactory
import com.example.myappicatleran.viewmodel.PhotoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoViewModel
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, PhotoViewModelFactory()).get(PhotoViewModel::class.java)
        recyclerView = findViewById(R.id.photoRecyclerView)
        photoAdapter = PhotoAdapter(emptyList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter

        viewModel.getPhotos().observe(this, { photos ->
            // Update your UI with the photos
            photoAdapter.updateData(photos)
        })
    }
}