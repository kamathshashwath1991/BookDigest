package com.kamath.bookdigest.data.remoteApi

import BookNeo
import com.kamath.bookdigest.data.model.Genre
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Neo4jApiService {
    @POST("createBook")
    suspend fun createBook(@Body book: BookNeo): Response<List<String>>
    @GET("books")
    suspend fun getAllBooks():Response<List<BookNeo>>
    @GET("genres")
    suspend fun getGenres():Response<List<Genre>>
}