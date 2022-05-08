package ru.kino.features.home.ui.viewpager.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.kino.features.home.R
import ru.kino.features.home.databinding.MovieItemBinding
import ru.kino.features.home.presentation.MovieContent
import ru.kino.shared.movie.domain.entity.MovieInformation

class MovieViewHolder(
	private val binding: MovieItemBinding,
	private val context: Context,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		movieContent: MovieContent,
		navigateToDetails: (MovieInformation) -> Unit,
	) {
		val information = movieContent as MovieContent.Information

		binding.container1.setOnClickListener {
			navigateToDetails(information.movie1)
		}
		binding.movieTitle.text = information.movie1.localizedName
		Glide
			.with(context)
			.load(information.movie1.imageUrl)
			.placeholder(R.drawable.error)
			.centerCrop()
			.into(binding.movieImage)

		if (information.movie2 != null) {
			binding.container2.isInvisible = false
			binding.container2.setOnClickListener {
				navigateToDetails(information.movie2)
			}
			binding.movieTitle2.text = information.movie2.localizedName
			Glide
				.with(context)
				.load(information.movie2.imageUrl)
				.centerCrop()
				.placeholder(R.drawable.error)
				.into(binding.movieImage2)
		} else {
			binding.container2.isInvisible = true
		}
	}

	companion object {

		fun from(
			parent: ViewGroup,
		): MovieViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
			return MovieViewHolder(binding, parent.context)
		}
	}
}