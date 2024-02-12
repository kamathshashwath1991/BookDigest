package com.kamath.bookdigest.data.remoteApi

import com.kamath.bookdigest.data.model.BookDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("book/{isbn}")
    suspend fun getBookDetails(
        @Path("isbn") isbn: String
    ): Response<BookDetailsResponse>
}