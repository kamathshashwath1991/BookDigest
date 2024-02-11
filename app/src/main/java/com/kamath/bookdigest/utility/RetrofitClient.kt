package com.kamath.bookdigest.utility

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitClient @Inject constructor(private val authInterceptor: AuthInterceptor) {
    private val baseUrl = "https://api2.isbndb.com/"

    fun create(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}