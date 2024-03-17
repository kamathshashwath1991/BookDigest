package com.kamath.bookdigest.data.remoteApi

import com.kamath.bookdigest.data.model.BookNeo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Neo4jApiService {
    @POST("createBook")
    suspend fun createBook(@Body book: BookNeo): Response<String>
}