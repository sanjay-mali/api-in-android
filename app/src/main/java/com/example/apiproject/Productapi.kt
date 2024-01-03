package com.example.apiproject

import android.telecom.Call
import retrofit2.http.GET

interface Productapi {

    @GET("products")
    fun getProducts(): retrofit2.Call<myProduct> // Call is a retrofit class
}