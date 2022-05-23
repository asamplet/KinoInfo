package ru.kino.features.home.ui

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.kino.features.home.presentation.Genres
import ru.kino.shared.movie.domain.entity.MovieInformation

interface HomeView : MvpView {

	@AddToEndSingle
	fun setData(filmList: List<MovieInformation>, genresList: List<Genres>, genre: String?)

	@AddToEndSingle
	fun showError()

	@AddToEndSingle
	fun hideLoading()
}