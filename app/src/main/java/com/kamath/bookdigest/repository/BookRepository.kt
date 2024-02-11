package com.kamath.bookdigest.repository

import android.util.Log
import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.data.remoteApi.BooksApiService
import com.kamath.bookdigest.utility.RetrofitClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(
    private val retrofitClient: RetrofitClient
) {
    private val TAG = "BOOK_REPOSITORY"

    private val retrofit = retrofitClient.create()
    private val booksApiService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
    suspend fun getBookDetails(isbn: String): BookDetailsResponse? {
        val response = booksApiService.getBookDetails(isbn)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}