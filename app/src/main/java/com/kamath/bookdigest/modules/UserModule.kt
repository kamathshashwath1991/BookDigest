package com.kamath.bookdigest.modules

import com.kamath.bookdigest.data.dao.UserDao
import com.kamath.bookdigest.data.remoteApi.UserApi
import com.kamath.bookdigest.data.remoteApi.UserApiImpl
import com.kamath.bookdigest.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UserModule {

//    @Provides
//    fun provideUserDao(): UserDao {
//
//    }

    @Provides
    fun provideUserApiService(): UserApi {
        return UserApiImpl().create()
    }

    @Provides
    fun provideUserRepository(userDao: UserDao, userApiService: UserApi): UserRepository {
        return UserRepository(userDao, userApiService)
    }
}