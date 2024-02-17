package com.kamath.bookdigest.repository

import android.util.Log
import com.kamath.bookdigest.data.model.ApiResponse
import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.data.remoteApi.BooksApiService
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response

@Singleton
class BookRepository @Inject constructor(
    private val booksApiService: BooksApiService
) {
    private val TAG = "BOOK_REPOSITORY"

    suspend fun getBookDetails(isbn: String): BookDetailsResponse? {
        try {
            val response: Response<BookDetailsResponse> = booksApiService.getBookDetails(isbn)
            if (response.isSuccessful) {
                val bookDetails = response.body()
                Log.d(TAG, "getBookDetails successful: $bookDetails")
                return bookDetails
            } else {
                Log.e(TAG, "getBookDetails unsuccessful: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "getBookDetails failed: ${e.message}", e)
        }
        return null
    }
}
