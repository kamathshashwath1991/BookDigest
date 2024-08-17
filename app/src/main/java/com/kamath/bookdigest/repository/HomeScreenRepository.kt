package com.kamath.bookdigest.repository

import BookNeo
import android.util.Log
import com.kamath.bookdigest.data.model.Genre
import com.kamath.bookdigest.data.remoteApi.Neo4jApiService
import retrofit2.Response
import javax.inject.Inject

class HomeScreenRepository @Inject constructor(private val neo4jApiService: Neo4jApiService){
    private val TAG = "HOME_SCREEN_REPO"

    suspend fun getAllBooks(): List<BookNeo>? {
        return try {
            val response = neo4jApiService.getAllBooks()
            if (response.errorBody() != null) {
                Log.d(TAG, "Raw JSON response: ${response.errorBody()?.string()}")
            }
            Log.d(TAG, "getAllBooks: response ---->${response}")

            if (response.isSuccessful) {
                val books = response.body()
                Log.d(TAG, "All Books are retrieved: $books")
                books
            } else {
                Log.e(TAG, "Error in getAllBooks: ${response.code()} - ${response.message()}")
                null
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception in getAllBooks", e)
            null
        }
    }

    suspend fun getGenres(): List<Genre>? {
        return try {
            val response: Response<List<Genre>> = neo4jApiService.getGenres()
            if (response.isSuccessful) {
                val genres = response.body()
                Log.d(TAG, "All Genres are retrieved: $genres")
                genres
            } else {
                Log.e(TAG, "Error in getGenres: ${response.code()} - ${response.message()}")
                null
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception in getGenres", e)
            null
        }
    }
}