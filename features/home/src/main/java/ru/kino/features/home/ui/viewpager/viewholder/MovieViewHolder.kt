package ru.kino.features.home.ui.viewpager.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.kino.features.home.R
import ru.kino.features.home.databinding.MovieItemBinding
import ru.kino.shared.movie.domain.entity.MovieInformation

class MovieViewHolder(
	private val binding: MovieItemBinding,
	private val context: Context,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		movieContent: MovieInformation,
		navigateToDetails: (MovieInformation) -> Unit,
	) {
		binding.container.setOnClickListener {
			navigateToDetails(movieContent)
		}
		binding.movieTitle.text = movieContent.localizedName
		Glide
			.with(context)
			.load(movieContent.imageUrl)
			.placeholder(R.drawable.error)
			.centerCrop()
			.into(binding.movieImage)
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