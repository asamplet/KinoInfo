package ru.kino.features.movieDetails.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import ru.kino.features.moiveDetails.R
import ru.kino.features.moiveDetails.databinding.FragmentDetailsBinding
import ru.kino.features.movieDetails.presentation.DetailsPresenter
import ru.kino.shared.movie.domain.entity.MovieInformation

class DetailsFragment : MvpAppCompatFragment(), DetailsView {

	private lateinit var movie: MovieInformation

	companion object {

		private const val MOVIE = "MOVIE"

		fun newInstance(movieInformation: MovieInformation) =
			DetailsFragment().apply {
				val bundle = Bundle()
				bundle.putSerializable(MOVIE, movieInformation)
				arguments = bundle
			}
	}

	private var _binding: FragmentDetailsBinding? = null
	private val binding: FragmentDetailsBinding
		get() = requireNotNull(_binding) { "binding can't be null" }

	@InjectPresenter
	lateinit var presenter: DetailsPresenter

	@ProvidePresenter
	fun provide(): DetailsPresenter = get()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentDetailsBinding.inflate(inflater, container, false)

		arguments?.getSerializable(MOVIE).let {
			movie = it as MovieInformation
		}
		presenter.setMovie(movie)

		binding.includeToolbar.backButton.setOnClickListener {
			presenter.navigateBack()
		}

		return binding.root
	}

	override fun setData(movieInformation: MovieInformation) {
		binding.includeToolbar.toolbarTitle.text = movieInformation.localizedName
		binding.englishTitleText.text = movieInformation.name
		binding.yearText.text = getString(R.string.year) + movieInformation.year
		binding.ratingText.text = movieInformation.rating?.let {
			getString(R.string.rating) + it
		}
		binding.descriptionText.text = movieInformation.description

		Glide
			.with(requireContext())
			.load(movieInformation.imageUrl)
			.placeholder(R.drawable.error)
			.centerCrop()
			.into(binding.movieImage)
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}