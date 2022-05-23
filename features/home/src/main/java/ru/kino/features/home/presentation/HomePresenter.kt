package ru.kino.features.home.presentation

import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import ru.kino.features.home.ui.HomeView
import ru.kino.shared.movie.domain.entity.MovieInformation
import ru.kino.shared.movie.domain.usecase.GetMovieUseCase

class HomePresenter(
	private val getMovieUseCase: GetMovieUseCase,
	private val router: HomeRouter,
) : MvpPresenter<HomeView>() {

	init {
		loadData()
	}

	private var movies: List<MovieInformation> = emptyList()
	private var genres = mutableListOf<String>()

	fun loadData() {
		presenterScope.launch {
			try {
				movies = getMovieUseCase()
				getGenres(movies)
				changeGenre(null)
				viewState.hideLoading()
			} catch (e: Exception) {
				viewState.showError()
			}
		}
	}

	private fun getGenres(moviesList: List<MovieInformation>) {
		moviesList.onEach {
			it.genres.onEach { genre ->
				genres.add(genre)
			}
		}
	}

	fun changeGenre(genre: String?) {
		viewState.setData(movies.applyGenre(genre), genres.selectGenre(genre), genre)
	}

	private fun List<MovieInformation>.applyGenre(genre: String?) =
		sortedBy { it.localizedName }.filter { it.genres.contains(genre) || genre.isNullOrEmpty() }

	private fun MutableList<String>.selectGenre(genre: String?) =
		distinct().map { Genres(it, it == genre) }

	fun navigateToDetails(movieInformation: MovieInformation) {
		router.navigateToDetail(movieInformation)
	}
}