package com.example.cinema.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

//    News
    fun getNews():Retrofit = Retrofit.Builder()
        .baseUrl("https://www.simplifiedcoding.net/demos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    Books
    fun getBooks():Retrofit = Retrofit.Builder()
        .baseUrl("https://harry-potter-api-en.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}