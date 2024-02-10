package com.kamath.bookdigest.modules
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kamath.bookdigest.data.remoteApi.GoogleBooksApiService
import com.kamath.bookdigest.repository.BookRepository
import com.kamath.bookdigest.utility.BarcodeScanner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    @Singleton
    @Provides
    fun provideGoogleApiBooksService(retrofit: Retrofit): GoogleBooksApiService {
        return retrofit.create(GoogleBooksApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesBooksRepository(bookApiService: GoogleBooksApiService) = BookRepository(bookApiService)

//    @Singleton
//    @Provides
//    fun provideApiKey():String{
//        return "AIzaSyAAd_g0si8fpOSaBlIA7fMe4xRYme0ebSM"
//    }
    @Provides
    fun provideBarcodeScanner(@ApplicationContext appContext: Context) = BarcodeScanner(appContext)

}