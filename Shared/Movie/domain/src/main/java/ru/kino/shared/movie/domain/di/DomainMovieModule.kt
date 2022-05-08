package ru.kino.shared.movie.domain.di

import org.koin.dsl.module
import ru.kino.shared.movie.domain.usecase.GetMovieUseCase

val domainMovieModule = module {
	factory { GetMovieUseCase(get()) }
}