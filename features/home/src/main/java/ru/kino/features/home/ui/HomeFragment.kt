package ru.kino.features.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import ru.kino.features.home.databinding.FragmentHomeBinding
import ru.kino.features.home.presentation.HomePresenter
import ru.kino.features.home.presentation.MovieContent
import ru.kino.features.home.ui.viewpager.MoviePageAdapter
import ru.kino.shared.movie.domain.entity.MovieInformation

class HomeFragment : MvpAppCompatFragment(), HomeView {

	private var _binding: FragmentHomeBinding? = null
	private val binding: FragmentHomeBinding
		get() = requireNotNull(_binding) { "binding can't be null" }

	@InjectPresenter
	lateinit var presenter: HomePresenter

	@ProvidePresenter
	fun provide(): HomePresenter = get()

	private lateinit var adapter: MoviePageAdapter

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)

		adapter = MoviePageAdapter(presenter::changeGenre, presenter::navigateToDetails)
		binding.movieRecyclerView.adapter = adapter

		return binding.root
	}

	override fun setData(filmList: List<MovieInformation>, genresList: List<String>, genre: String?) {
		binding.lupa.isVisible = false
		val elements = listOf(
			MovieContent.GenresTitle,
		) +	genresList.map {
			MovieContent.Genres(it, it == genre)
		} + MovieContent.MovieTitle +
			filmList.withIndex().groupBy {
				it.index / 2
			}.map {
				it.value.map { it.value }
			}.map {
				MovieContent.Information(it[0], it.getOrNull(1))
			}


		adapter.submitList(elements)
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}