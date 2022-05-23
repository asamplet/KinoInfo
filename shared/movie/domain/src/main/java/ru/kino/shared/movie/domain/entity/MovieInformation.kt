package ru.kino.shared.movie.domain.entity

import java.io.Serializable

data class MovieInformation (
	val id: Int,
	val localizedName: String,
	val name: String,
	val year: Int,
	val rating: Double?,
	val imageUrl: String?,
	val description: String?,
	val genres: List<String>,
) : Serializable