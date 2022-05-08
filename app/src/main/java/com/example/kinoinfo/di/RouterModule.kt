package com.example.kinoinfo.di

import com.example.kinoinfo.ui.router.DetailsRouterImpl
import com.example.kinoinfo.ui.router.HomeRouterImpl
import org.koin.dsl.module
import ru.kino.features.home.presentation.HomeRouter
import ru.kino.features.movieDetails.presentation.DetailsRouter

val routerModule = module {
	factory<HomeRouter> { HomeRouterImpl(get()) }
	factory<DetailsRouter> { DetailsRouterImpl(get()) }
}