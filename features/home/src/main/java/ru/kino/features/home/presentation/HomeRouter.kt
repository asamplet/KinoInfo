package ru.kino.features.home.presentation

import ru.kino.shared.movie.domain.entity.MovieInformation

interface HomeRouter {

	fun navigateToDetail(movieInformation: MovieInformation)
}