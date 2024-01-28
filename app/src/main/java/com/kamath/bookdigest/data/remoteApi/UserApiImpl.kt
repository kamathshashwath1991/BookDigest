package com.kamath.bookdigest.data.remoteApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserApiImpl {
    companion object{
        private const val BASE_URL = "https://test.com"
    }

    fun create():UserApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
}