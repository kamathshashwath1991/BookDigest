package com.kamath.bookdigest.data

import java.time.LocalDate
import java.util.Date

data class User(
    val id:String,
    val username:String,
    val listOfBooks:List<String>,//temporary String, later to be changed to Book type
    val rating:Int,
    val listedBook: Book
)

data class Book(
    val id:String,
    val isbn:String,
    val bookTitle:String,
    val author:List<String>,//temporary String, later to be changed to Author type
    val genre:List<String>,//temporary String, later to be changed to Category type
    val format:String,
    val listedDate:LocalDate,
    val published:LocalDate,
    val condition:String
)

data class Author(
    val id:String,
    val listBooks:List<Book>
)

data class Category(
    val id:String,
    val type:String
)
