package ru.kino.features.movieDetails.presentation

import moxy.MvpPresenter
import ru.kino.features.movieDetails.ui.DetailsView
import ru.kino.shared.movie.domain.entity.MovieInformation

class DetailsPresenter(
	private val data: MovieInformation,
	private val router: DetailsRouter,
) : MvpPresenter<DetailsView>() {

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()
		viewState.setData(data)
	}

	fun navigateBack(){
		router.navigateBack()
	}
}