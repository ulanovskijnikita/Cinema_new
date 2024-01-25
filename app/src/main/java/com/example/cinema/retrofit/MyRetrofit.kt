package com.example.cinema.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    fun getRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl("https://www.simplifiedcoding.net/demos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}