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
            .addHeader("accept","application/json")
            .addHeader("Authorization",apiKey)
            .build()
        return chain.proceed(modifiedRequest)
    }

}