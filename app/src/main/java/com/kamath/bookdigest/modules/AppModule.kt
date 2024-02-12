package com.kamath.bookdigest.modules
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kamath.bookdigest.repository.BookRepository
import com.kamath.bookdigest.utility.AuthInterceptor
import com.kamath.bookdigest.utility.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val  apiKey = "51768_c90f4b3c9cf86c4fbf1f2c8120482089"

    @Provides
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor(apiKey)
    }
    @Provides
    fun provideRetrofitClient(authInterceptor: AuthInterceptor): RetrofitClient {
        return RetrofitClient(authInterceptor)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideBooksRepository(retrofitClient: RetrofitClient): BookRepository {
        return BookRepository(retrofitClient)
    }
}