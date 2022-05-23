package ru.kino.shared.movie.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieInformationDto(
	@Json(name = "id") val id: Int,
	@Json(name = "localized_name") val localizedName: String,
	@Json(name = "name") val name: String,
	@Json(name = "year") val year: Int,
	@Json(name = "rating") val rating: Double?,
	@Json(name = "image_url") val imageUrl: String?,
	@Json(name = "description") val description: String?,
	@Json(name = "genres") val genres: List<String>,
)