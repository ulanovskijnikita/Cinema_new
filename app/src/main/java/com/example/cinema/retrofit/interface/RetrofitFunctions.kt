package com.example.cinema.retrofit.`interface`

import com.example.cinema.retrofit.model.DataBooks
import com.example.cinema.retrofit.model.DataCharacters
import com.example.cinema.retrofit.model.DataMovie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitFunctions {

//    News
    @GET("marvel")
    fun getData():Call<List<DataMovie>>

//    Books
    @GET("books")
    suspend fun getBooks(): List<DataBooks>

    @GET("characters")
    suspend fun getCharacter(): List<DataCharacters>
}