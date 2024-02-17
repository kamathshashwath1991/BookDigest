package com.kamath.bookdigest.modules
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kamath.bookdigest.data.remoteApi.BooksApiService
import com.kamath.bookdigest.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor{chain ->
                val newRequest = chain
                    .request().newBuilder()
                    .addHeader("accept","application/json")
                    .addHeader("Authorization","51768_c90f4b3c9cf86c4fbf1f2c8120482089")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://api2.isbndb.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): BooksApiService {
        return retrofit.create(BooksApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideBooksRepository(apiService: BooksApiService) = BookRepository(apiService)

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}