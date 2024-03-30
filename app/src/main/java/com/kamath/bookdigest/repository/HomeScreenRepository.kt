package com.kamath.bookdigest.repository

import android.util.Log
import com.kamath.bookdigest.data.model.BookNeo
import com.kamath.bookdigest.data.remoteApi.Neo4jApiService
import retrofit2.Response
import javax.inject.Inject

class HomeScreenRepository @Inject constructor(private val neo4jApiService: Neo4jApiService){
    private val TAG = "HOME_SCREEN_REPO"
    suspend fun getAllBooks():List<BookNeo>?{
        try{
            val response:Response<List<BookNeo>> = neo4jApiService.getAllBooks()
            if (response.isSuccessful){
                val books = response.body()
                Log.d(TAG,"All Books are retrieved for this account : $response")
                return books
            }
            else{
                Log.d(TAG, "getAllBooks: ${response.code()}")
            }
        }catch (e:Exception){
            Log.e(TAG, "getAllBooks: ${e.message}", )
        }
        return null
    }
}