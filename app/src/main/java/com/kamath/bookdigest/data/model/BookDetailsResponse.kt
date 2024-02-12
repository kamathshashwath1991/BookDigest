package com.kamath.bookdigest.data.model

data class BookDetailsResponse(
    val title: String,
    val title_long: String,
    val isbn: String,
    val isbn13: String,
    val dewey_decimal: String,
    val binding: String,
    val publisher: String,
    val language: String,
    val date_published: String,
    val edition: String,
    val pages: String,
    val dimensions: String,
    val overview: String,
    val image: String,
    val msrp: String,
    val excerpt: String,
    val synopsis: String,
    val authors: String,
    val subjects: String,
    val reviews: String,
    val prices: String,

)
