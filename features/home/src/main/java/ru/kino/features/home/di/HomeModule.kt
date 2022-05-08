package ru.kino.features.home.di

import org.koin.dsl.module
import ru.kino.features.home.presentation.HomePresenter

val homeModule = module {
	factory {
		HomePresenter(
			getMovieUseCase = get(),
			router = get(),
		)
	}
}