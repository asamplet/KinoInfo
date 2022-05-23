package ru.kino.features.movieDetails.di

import org.koin.dsl.module
import ru.kino.features.movieDetails.presentation.DetailsPresenter
import ru.kino.shared.movie.domain.entity.MovieInformation

val detailsModule = module {
	factory { (data: MovieInformation) ->
		DetailsPresenter(
			data = data,
			router = get(),
		)
	}
}