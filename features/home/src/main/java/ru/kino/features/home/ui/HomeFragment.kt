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

	private var adapter: MoviePageAdapter? = null

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)

		adapter = MoviePageAdapter(presenter::changeGenre, presenter::navigateToDetails)
		binding.content.adapter = adapter

		binding.errorButton.setOnClickListener {
			binding.progress.isVisible = true
			binding.error.isVisible = false
			presenter.loadData()
		}

		return binding.root
	}

	override fun setData(filmList: List<MovieInformation>, genresList: List<String>, genre: String?) {
		binding.progress.isVisible = false
		binding.content.isVisible = true
		binding.error.isVisible = false

		val elements = listOf(MovieContent.GenresTitle) +
			genresList.map {
				MovieContent.Genres(it, it == genre)
			} +
			MovieContent.MovieTitle +
			filmList.withIndex().groupBy {
				it.index / 2
			}.map {
				it.value.map { it.value }
			}.map {
				MovieContent.Information(it[0], it.getOrNull(1))
			}

		adapter?.submitList(elements)
	}

	override fun showError() {
		binding.error.isVisible = true
		binding.progress.isVisible = false
		binding.content.isVisible = false
	}

	override fun onDestroyView() {
		adapter = null
		binding.content.adapter = null
		_binding = null
		super.onDestroyView()
	}
}