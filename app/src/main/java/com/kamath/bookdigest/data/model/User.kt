package com.kamath.bookdigest.data.model

import android.os.Build
import android.os.Message
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


data class SignInResult(
    val data : UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId:String,
    val username:String,
    val profilePictureUrl:String
)
data class User(
    val id: String,
    val username:String,
    val listOfBooks:List<String>,// temporary String, later to be changed to Book type
    val rating:Int,
    val listedBook: Book
)

data class Book @RequiresApi(Build.VERSION_CODES.O) constructor(
    val id:String,
    val isbn:String,
    val bookTitle:String,
    val author:List<String>,//temporary String, later to be changed to Author type
    val genre:List<String>,//temporary String, later to be changed to Category type
    val format:String,
    val listedDate:LocalDate,
    val published:LocalDate,
    val condition:String,
    val maxReturnDate:LocalDate = LocalDate.MAX
)

data class Author(
    val id:String,
    val listBooks:List<Book>
)

data class Category(
    val id:String,
    val type:String
)
