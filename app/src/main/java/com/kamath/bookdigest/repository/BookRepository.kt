package com.kamath.bookdigest.repository

import android.util.Log
import com.kamath.bookdigest.data.model.ApiResponse
import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.data.remoteApi.BooksApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(
    private val booksApiService: BooksApiService
) {
    private val TAG = "BOOK_REPOSITORY"

    suspend fun getBookDetails(isbn: String): ApiResponse<BookDetailsResponse> {
        return try {
            val response = booksApiService.getBookDetails<BookDetailsResponse>(isbn)
            if (response.data!=null) {
                val bookDetails = response.data
                ApiResponse(data = bookDetails, error = null)
            } else {
                ApiResponse(data = null, error = Exception("Failed to fetch book details"))
            }
        } catch (e: Exception) {
            ApiResponse(data = null, error = e)
        }
    }
}