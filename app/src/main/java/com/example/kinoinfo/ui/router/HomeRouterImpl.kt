package com.example.kinoinfo.ui.router

import com.github.terrakok.cicerone.Router
import ru.kino.features.home.presentation.HomeRouter
import ru.kino.features.movieDetails.ui.getDetailsScreen
import ru.kino.shared.movie.domain.entity.MovieInformation

class HomeRouterImpl(
	private val router: Router
) : HomeRouter {

	override fun navigateToDetail(movieInformation: MovieInformation) {
		router.navigateTo(getDetailsScreen(movieInformation))
	}
}