package ru.kino.features.home.ui.viewpager

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.kino.features.home.R
import ru.kino.features.home.presentation.MovieContent
import ru.kino.features.home.ui.viewpager.viewholder.GenresViewHolder
import ru.kino.features.home.ui.viewpager.viewholder.TitleViewHolder
import ru.kino.features.home.ui.viewpager.viewholder.MovieViewHolder
import ru.kino.shared.movie.domain.entity.MovieInformation

class MoviePageAdapter(
	private val updateGenre: (String?) -> Unit,
	private val navigateToDetails: (MovieInformation) -> Unit,
) : ListAdapter<MovieContent, RecyclerView.ViewHolder>(MovieDiffCallback()) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): RecyclerView.ViewHolder {
		return when (viewType) {
			R.layout.movie_item -> MovieViewHolder.from(parent)

			R.layout.genre_item -> GenresViewHolder.from(parent)

			R.layout.title_item -> TitleViewHolder.from(parent)

			else                -> throw IllegalArgumentException("Unsupported layout")
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (getItem(position)) {
			is MovieContent.Genres      -> R.layout.genre_item

			is MovieContent.Information -> R.layout.movie_item

			is MovieContent.Title       -> R.layout.title_item
		}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (val item = getItem(position)) {
			is MovieContent.Genres      -> (holder as GenresViewHolder).bind(getItem(position), updateGenre)

			is MovieContent.Information -> (holder as MovieViewHolder).bind(getItem(position), navigateToDetails)

			is MovieContent.Title       -> (holder as TitleViewHolder).bind(item)
		}
	}
}

class MovieDiffCallback : DiffUtil.ItemCallback<MovieContent>() {

	override fun areItemsTheSame(oldItem: MovieContent, newItem: MovieContent) = oldItem == newItem

	override fun areContentsTheSame(oldItem: MovieContent, newItem: MovieContent) = oldItem == newItem
}