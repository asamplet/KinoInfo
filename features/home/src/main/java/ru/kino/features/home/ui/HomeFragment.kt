package ru.kino.features.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import ru.kino.features.home.R
import ru.kino.features.home.databinding.FragmentHomeBinding
import ru.kino.features.home.presentation.Genres
import ru.kino.features.home.presentation.HomePresenter
import ru.kino.features.home.ui.viewpager.GenresPageAdapter
import ru.kino.features.home.ui.viewpager.MoviePageAdapter
import ru.kino.features.home.ui.viewpager.TitleAdapter
import ru.kino.shared.movie.domain.entity.MovieInformation

class HomeFragment : MvpAppCompatFragment(), HomeView {

	private var _binding: FragmentHomeBinding? = null
	private val binding: FragmentHomeBinding
		get() = requireNotNull(_binding) { "binding can't be null" }

	@InjectPresenter
	lateinit var presenter: HomePresenter

	@ProvidePresenter
	fun provide(): HomePresenter = get()

	private var movieAdapter: MoviePageAdapter? = null
	private var genreAdapter: GenresPageAdapter? = null
	private var adapter: ConcatAdapter? = null

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)

		val genresTitleAdapter = TitleAdapter(getString(R.string.genres))
		genreAdapter = GenresPageAdapter(presenter::changeGenre)
		val movieTitleAdapter = TitleAdapter(getString(R.string.movies))
		movieAdapter = MoviePageAdapter(presenter::navigateToDetails)

		adapter = ConcatAdapter(
			ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
			genresTitleAdapter,
			genreAdapter,
			movieTitleAdapter,
			movieAdapter,
		)
		binding.content.adapter = adapter

		setupLayoutManager()
		setErrorListener()

		return binding.root
	}

	private fun setupLayoutManager(){
		val layoutManager = GridLayoutManager(requireContext(), 2)
		layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
			override fun getSpanSize(position: Int): Int =
				when (adapter?.getItemViewType(position)) {
					R.layout.movie_item -> 1
					else                -> 2
				}
		}
		binding.content.layoutManager = layoutManager
	}

	private fun setErrorListener(){
		binding.errorButton.setOnClickListener {
			binding.error.isVisible = false
			binding.progress.isVisible = true
			presenter.loadData()
		}
	}

	override fun setData(filmList: List<MovieInformation>, genresList: List<Genres>, genre: String?) {
		genreAdapter?.submitList(genresList)
		movieAdapter?.submitList(filmList)
	}

	override fun showError() {
		binding.error.isVisible = true
		binding.progress.isVisible = false
		binding.content.isVisible = false
	}

	override fun hideLoading() {
		binding.error.isVisible = false
		binding.progress.isVisible = false
		binding.content.isVisible = true
	}

	override fun onDestroyView() {
		movieAdapter = null
		genreAdapter = null
		binding.content.adapter = null
		_binding = null
		super.onDestroyView()
	}
}