data class BookNeo(
 val publisher: String,
 val synopsis: String,
 val language: String,
 val image: String,
 val titleLong: String,
 val dimensions: DimensionsStructured,
 val pages: String,
 val datePublished: String,
 val subjects: List<String>,
 val authors: List<String>,
 val name: String,
 val isbn13: String,
 val msrp: String,
 val binding: String,
 val isbn: String,
 val isbn10: String
)

data class DimensionsStructured(
 val length: Dimension,
 val width: Dimension,
 val weight: Dimension,
 val height: Dimension
)

data class Dimension(
 val unit: String,
 val value: Double
)