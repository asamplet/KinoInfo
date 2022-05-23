package com.example.kinoinfo.ui.router

import com.example.kinoinfo.presentation.MainRouter
import com.github.terrakok.cicerone.Router
import ru.kino.features.home.ui.getHomeScreen

class MainRouterImpl(
	private val router: Router
): MainRouter {

	override fun newRoot() {
		router.newRootScreen(getHomeScreen())
	}
}