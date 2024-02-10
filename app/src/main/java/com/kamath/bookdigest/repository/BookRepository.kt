package com.kamath.bookdigest.repository

import android.util.Log
import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.data.remoteApi.GoogleBooksApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(
    private val bookService: GoogleBooksApiService
) {
    private val TAG = "BOOK REPOSITORY"
     suspend fun getBookInfoByIsbn(isbn:String): BookDetailsResponse {
         Log.d(TAG, "getBookInfoByIsbn: Inside repo")
        return bookService.getBookInfoByIsbn(isbn,"AIzaSyAAd_g0si8fpOSaBlIA7fMe4xRYme0ebSM")
    }
}