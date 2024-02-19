package com.example.cinema.retrofit.model

//News
data class DataMovie(
    val name: String,
    val realname: String,
    val team: String,
    val firstappearance: String,
    val createdby: String,
    val publisher: String,
    val imageurl: String,
    val bio: String)

//Books
data class DataBooks(
    val title: String,
    val releaseDay: String
)

data class DataCharacters(
    val image: String,
    val character: String,
    val hogwartsHouse: String
)
