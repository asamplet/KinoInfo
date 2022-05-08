package ru.kino.features.movieDetails.presentation

import moxy.MvpPresenter
import ru.kino.features.movieDetails.ui.DetailsView
import ru.kino.shared.movie.domain.entity.MovieInformation

class DetailsPresenter(
	private val router: DetailsRouter,
) : MvpPresenter<DetailsView>() {

	fun navigateBack(){
		router.navigateBack()
	}

	fun setMovie(movieInformation: MovieInformation){
		viewState.setData(movieInformation)
	}
}