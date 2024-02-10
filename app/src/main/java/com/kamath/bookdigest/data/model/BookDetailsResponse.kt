package com.kamath.bookdigest.data.model

data class BookDetailsResponse(
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String?,
    // Add other fields as needed
)
