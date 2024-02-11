package com.kamath.bookdigest.utility

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(private val apiKey: String):Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
//            .addHeader("Host", "api2.isbndb.com")
//            .addHeader("User-Agent", "insomnia/5.12.4")
            .addHeader("Content-Type","application/json")
            .addHeader("Authorization",apiKey)
            .build()
        return chain.proceed(modifiedRequest)
    }

}