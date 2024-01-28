package com.kamath.bookdigest.modules

//import com.kamath.bookdigest.data.dao.UserDao
import com.kamath.bookdigest.data.remoteApi.UserApi
import com.kamath.bookdigest.data.remoteApi.UserApiImpl
//import com.kamath.bookdigest.database.AppDatabase
import com.kamath.bookdigest.repository.UserRepository
import com.kamath.bookdigest.viewModels.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

//    @Provides
//    fun provideUserDao(): UserDao {
//
//    }
//@Singleton
//@Provides
//fun provideUserDao(): UserDao {
//    return AppDatabase.getInstance().userDao()
//}

    @Provides
    @Singleton
    fun provideUserApiService(): UserApi {
        return UserApiImpl().create()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userApiService: UserApi): UserRepository {
        return UserRepository(userApiService)
    }

}