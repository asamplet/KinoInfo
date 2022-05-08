package ru.kino.features.movieDetails.di

import org.koin.dsl.module
import ru.kino.features.movieDetails.presentation.DetailsPresenter

val detailsModule = module {
	factory {
		DetailsPresenter(
			router = get(),
		)
	}
}