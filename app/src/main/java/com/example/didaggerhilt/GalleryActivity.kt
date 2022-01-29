package com.example.didaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.didaggerhilt.api.Api
import com.example.didaggerhilt.databinding.ActivityGalleryBinding
import com.example.didaggerhilt.model.GalleryModel
import com.example.didaggerhilt.view.PhotoAdapter
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GalleryActivity : AppCompatActivity() {
    lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = GridLayoutManager(this, 2)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)

        api.getPhotos().enqueue(object : Callback<List<GalleryModel>> {
            override fun onResponse(
                call: Call<List<GalleryModel>>,
                response: Response<List<GalleryModel>>
            ) {
                binding.recycler.adapter = PhotoAdapter(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<GalleryModel>>, t: Throwable) {
                Toast.makeText(this@GalleryActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })

    }
}