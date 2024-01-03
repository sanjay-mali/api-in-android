package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Productapi::class.java)

        val retrofitData = retrofitBuilder.getProducts()
        retrofitData.enqueue(object : Callback<myProduct?> {
            override fun onResponse(call: Call<myProduct?>, response: Response<myProduct?>) {
                val responseBody = response.body()
                val productLists = responseBody?.products!!

                myAdapter = MyAdapter(this@MainActivity,productLists)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)




            }

            override fun onFailure(call: Call<myProduct?>, t: Throwable) {
                Log.d("Main Activity","Error" + t.message)
            }
        })

    }
}