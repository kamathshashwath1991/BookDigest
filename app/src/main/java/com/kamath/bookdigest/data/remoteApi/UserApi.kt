package com.kamath.bookdigest.data.remoteApi

import com.kamath.bookdigest.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("user/{userId}")
    suspend fun getUserById(@Path("userId") userId: String): User
}