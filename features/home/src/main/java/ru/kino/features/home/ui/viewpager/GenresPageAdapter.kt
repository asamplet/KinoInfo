package ru.kino.features.home.ui.viewpager

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.kino.features.home.R
import ru.kino.features.home.presentation.Genres
import ru.kino.features.home.ui.viewpager.viewholder.GenresViewHolder

class GenresPageAdapter(
	private val updateGenre: (String?) -> Unit,
) : ListAdapter<Genres, GenresViewHolder>(GenresDiffCallback()) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): GenresViewHolder {
		return GenresViewHolder.from(parent)
	}

	override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
		holder.bind(getItem(position), updateGenre)
	}

	override fun getItemViewType(position: Int): Int = R.layout.genre_item
}

class GenresDiffCallback : DiffUtil.ItemCallback<Genres>() {

	override fun areItemsTheSame(oldItem: Genres, newItem: Genres) = oldItem == newItem

	override fun areContentsTheSame(oldItem: Genres, newItem: Genres) = oldItem.genre == newItem.genre
}