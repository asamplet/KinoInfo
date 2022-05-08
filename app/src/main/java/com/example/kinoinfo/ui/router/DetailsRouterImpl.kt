package com.example.kinoinfo.ui.router

import com.github.terrakok.cicerone.Router
import ru.kino.features.movieDetails.presentation.DetailsRouter

class DetailsRouterImpl(
	private val router: Router,
) : DetailsRouter {

	override fun navigateBack() {
		router.exit()
	}
}