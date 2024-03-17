package com.kamath.bookdigest.data.model

import com.google.gson.annotations.SerializedName

data class BookNeo(
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("year") val year: Int,
    @SerializedName("genre") val genre: String,
    @SerializedName("pages") val pages: Int,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("published_date") val publishedDate: String,
    @SerializedName("original_cost") val originalCost: Double
)
