package ru.kino.features.home.presentation

import ru.kino.shared.movie.domain.entity.MovieInformation

sealed interface MovieContent {

	sealed interface Title : MovieContent

	object GenresTitle : Title

	object MovieTitle : Title

	data class Genres(
		val genre: String,
		val active: Boolean,
	) : MovieContent

	data class Information(
		val movie1: MovieInformation,
		val movie2: MovieInformation?,
	) : MovieContent
}