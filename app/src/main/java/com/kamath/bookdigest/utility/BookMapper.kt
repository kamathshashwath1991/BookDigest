package com.kamath.bookdigest.utility

import BookNeo
import Dimension
import DimensionsStructured
import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.data.model.DimensionItem
import com.kamath.bookdigest.data.model.Dimensions

object BookMapper {

    fun convertBookToNeo(bookDetailsResponse:BookDetailsResponse):BookNeo{
        val book = bookDetailsResponse.book
        return BookNeo(
            publisher = book.publisher ?: "Unknown publisher",
            synopsis = book.synopsis ?: "No synopsis available",
            language = book.language ?: "Unknown language",
            image = book.image ?: "",
            titleLong = book.title_long ?: "No title",
            dimensions = convertDimensions(book.dimensions_structured),
            pages = book.pages?.toString() ?: "Unknown pages",
            datePublished = book.date_published ?: "Unknown date",
            subjects = emptyList(),
            authors = book.authors ?: emptyList(),
            name = book.title ?: "No name",
            isbn13 = book.isbn13 ?: "Unknown ISBN-13",
            msrp = book.msrp ?: "Unknown MSRP",
            binding = book.binding ?: "Unknown binding",
            isbn = book.isbn ?: "Unknown ISBN",
            isbn10 = book.isbn10 ?: "Unknown ISBN-10"
        )
    }
    private fun convertDimensions(dimensions: Dimensions?): DimensionsStructured {
        return DimensionsStructured(
            length = convertDimension(dimensions?.length),
            width = convertDimension(dimensions?.width),
            weight = convertDimension(dimensions?.weight),
            height = convertDimension(dimensions?.height)
        )
    }

    private fun convertDimension(dimensionItem: DimensionItem?): Dimension {
        return Dimension(
            unit = dimensionItem?.unit ?: "cm",
            value = dimensionItem?.value ?: 0.0
        )
    }
}