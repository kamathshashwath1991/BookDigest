package com.kamath.bookdigest.data.model

data class BookDetailsResponse(
    val book: Book
)

data class Book(
    val publisher: String?,
    val language: String?,
    val image: String?,
    val title_long: String?,
    val dimensions: String?,
    val dimensions_structured: Dimensions?,
    val pages: Int?,
    val date_published: String?,
    val authors: List<String>?,
    val title: String?,
    val isbn13: String?,
    val msrp: String?,
    val binding: String?,
    val isbn: String?,
    val isbn10: String?,
    val other_isbns: List<OtherIsbn>?
)

data class Dimensions(
    val length: DimensionItem?,
    val width: DimensionItem?,
    val weight: DimensionItem?,
    val height: DimensionItem?
)

data class DimensionItem(
    val unit: String?,
    val value: Double?
)

data class OtherIsbn(
    val isbn: String?,
    val binding: String?
)


data class ApiResponse<T>(
    val data: T?,
    val error: Throwable?
)
