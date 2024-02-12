package com.kamath.bookdigest.utility

import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.data.remoteApi.BooksApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RetrofitClient @Inject constructor(private val authInterceptor: AuthInterceptor) {
    private val baseUrl = "https://api2.isbndb.com/"

    val booksApiService: BooksApiService
    val  apiKey = "51768_c90f4b3c9cf86c4fbf1f2c8120482089"

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
        //    .addInterceptor(logging)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("Authorization",apiKey)
                    .build()
                chain.proceed(newRequest)
            }
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        booksApiService = retrofit.create(BooksApiService::class.java)
    }

    suspend fun getBookDetails(
        isbn: String
    ): Response<BookDetailsResponse> {
        return booksApiService.getBookDetails(isbn)
    }
}