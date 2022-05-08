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

	private fun loadData() {
		presenterScope.launch {
			movies = getMovieUseCase()
			getGenres(movies)
			viewState.setData(movies.sortedBy { it.localizedName }, genres.distinct(), null)
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
		viewState.setData(movies
							  .sortedBy { it.localizedName }
							  .filter { it.genres.contains(genre) || genre.isNullOrEmpty() },
						  genres.distinct(),
						  genre
		)
	}

	fun navigateToDetails(movieInformation: MovieInformation) {
		router.navigateToDetail(movieInformation)
	}
}