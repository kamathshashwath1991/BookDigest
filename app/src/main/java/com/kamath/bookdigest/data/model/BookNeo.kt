package com.kamath.bookdigest.data.model

import com.google.gson.annotations.SerializedName

data class BookNeo(
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("year") val year: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("pages") val pages: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("publishedDate") val publishedDate: String,
    @SerializedName("originalCost") val originalCost: String
)
