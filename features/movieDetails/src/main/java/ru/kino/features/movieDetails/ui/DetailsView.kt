package ru.kino.features.movieDetails.ui

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import ru.kino.shared.movie.domain.entity.MovieInformation

interface DetailsView : MvpView {

	@AddToEnd
	fun setData(movieInformation: MovieInformation)
}