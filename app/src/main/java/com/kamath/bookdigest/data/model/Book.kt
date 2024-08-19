data class Book(
    val publisher: String?,
    val synopsis: String?,
    val language: String?,
    val image: String?,
    val titleLong: String?,
    val edition: String?,
    val dimensions: String?,
    val dimensionsStructured: DimensionsStructured?,
    val pages: Int?,
    val datePublished: String?,
    val subjects: List<String>?,
    val authors: List<String>?,
    val title: String?,
    val isbn13: String?,
    val msrp: String,
    val binding: String?,
    val related: Related?,
    val isbn: String?,
    val isbn10: String?,
    val otherIsbns: List<OtherIsbn>?
)

data class Related(
    val ePub: String?
)

data class OtherIsbn(
    val isbn: String?,
    val binding: String?
)