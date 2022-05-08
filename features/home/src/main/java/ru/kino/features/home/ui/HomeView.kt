package ru.kino.features.home.ui

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip
import ru.kino.shared.movie.domain.entity.MovieInformation

interface HomeView : MvpView {

	@AddToEndSingle
	fun setData(filmList: List<MovieInformation>, genresList: List<String>, genre: String?)
}