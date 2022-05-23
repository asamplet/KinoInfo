package ru.kino.features.home.ui.viewpager

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.kino.features.home.R
import ru.kino.features.home.presentation.Genres
import ru.kino.features.home.ui.viewpager.viewholder.GenresViewHolder
import ru.kino.features.home.ui.viewpager.viewholder.MovieViewHolder
import ru.kino.shared.movie.domain.entity.MovieInformation

class MoviePageAdapter(
	private val navigateToDetails: (MovieInformation) -> Unit,
) : ListAdapter<MovieInformation, MovieViewHolder>(MovieDiffCallback()) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): MovieViewHolder {
		return MovieViewHolder.from(parent)
	}

	override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
		holder.bind(getItem(position), navigateToDetails)
	}

	override fun getItemViewType(position: Int): Int = R.layout.movie_item
}

class MovieDiffCallback : DiffUtil.ItemCallback<MovieInformation>() {

	override fun areItemsTheSame(oldItem: MovieInformation, newItem: MovieInformation) = oldItem == newItem

	override fun areContentsTheSame(oldItem: MovieInformation, newItem: MovieInformation) = oldItem.id == newItem.id
}