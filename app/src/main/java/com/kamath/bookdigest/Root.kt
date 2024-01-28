package com.kamath.bookdigest

import android.app.Application
import androidx.room.Room
//import com.kamath.bookdigest.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Root:Application() {
//    val database: AppDatabase by lazy {
//        Room.databaseBuilder(this, AppDatabase::class.java, "my-database")
//            .build()
//    }
}