package com.example.cinema.retrofit.`interface`

import com.example.cinema.retrofit.model.DataMovie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServieces {
    @GET("marvel")
    fun getData():Call<MutableList<DataMovie>>
}