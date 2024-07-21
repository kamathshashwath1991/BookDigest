package com.kamath.bookdigest.di
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kamath.bookdigest.data.remoteApi.IsbnApiService
import com.kamath.bookdigest.data.remoteApi.Neo4jApiService
import com.kamath.bookdigest.repository.BookRepository
import com.kamath.bookdigest.repository.HomeScreenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
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
    @Named("isbnRetrofit")
    fun provideIsbnRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api2.isbndb.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("neo4jRetrofit")
    fun provideNeo4jRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/") // Adjust the base URL as needed
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(@Named("isbnRetrofit")retrofit: Retrofit): IsbnApiService {
        return retrofit.create(IsbnApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNeo4jApiService(@Named("neo4jRetrofit") retrofit: Retrofit): Neo4jApiService {
        return retrofit.create(Neo4jApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideBooksRepository(isbnApiService: IsbnApiService,
                               neo4jApiService: Neo4jApiService) = BookRepository(isbnApiService,neo4jApiService)

    @Provides
    @Singleton
    fun provideHomeScreenRepository(neo4jApiService: Neo4jApiService) = HomeScreenRepository(neo4jApiService)

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}