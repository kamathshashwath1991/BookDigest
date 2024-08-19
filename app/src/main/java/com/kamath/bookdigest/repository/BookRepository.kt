package com.kamath.bookdigest.repository

import Book
import BookNeo
import android.util.Log
import com.kamath.bookdigest.data.remoteApi.IsbnApiService
import com.kamath.bookdigest.data.remoteApi.Neo4jApiService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(
    private val isbnApiService: IsbnApiService,
    private val neo4jApiService: Neo4jApiService
) {
    private val TAG = "BOOK_REPOSITORY"

    suspend fun getBookDetails(isbn: String): Book? {
        try {
            val response: Response<Book> = isbnApiService.getBookDetails(isbn)
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

    suspend fun createBook(book: BookNeo){
        try {
            val response = neo4jApiService.createBook(book)
            if (response.isSuccessful) {
                // Response is successful, extract and return the response body
                Log.d(TAG, "API call is successful:")
            }
        } catch (e: Exception) {
            // Exception occurred, log the error
            Log.e(TAG, "API call is unsuccessful:")
        }
    }
}
