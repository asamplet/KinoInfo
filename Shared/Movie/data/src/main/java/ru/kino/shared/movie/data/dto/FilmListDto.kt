package ru.kino.shared.movie.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmListDto (
	@Json(name = "films") val films: List<MovieInformationDto>,
)