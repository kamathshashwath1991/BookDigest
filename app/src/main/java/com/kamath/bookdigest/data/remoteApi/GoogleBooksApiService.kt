package com.kamath.bookdigest.data.remoteApi

import com.kamath.bookdigest.data.model.BookDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApiService {
    @GET("volumes")
    suspend fun getBookInfoByIsbn(
        @Query("q") query: String,
        @Query("key") apiKey: String
    ): BookDetailsResponse


}