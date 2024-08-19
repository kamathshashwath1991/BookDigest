package com.kamath.bookdigest.data.remoteApi
import Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IsbnApiService {
    @GET("book/{isbn}")
    suspend fun getBookDetails(
        @Path("isbn") isbn: String
    ): Response<Book>
}