package ru.kino.features.home.ui.viewpager.viewholder

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kino.features.home.databinding.GenreItemBinding
import ru.kino.features.home.presentation.Genres

class GenresViewHolder(
	private val binding: GenreItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		genre: Genres,
		updateGenre: (String?) -> Unit,
	) {

		binding.genreTitle.text = genre.genre
		when (genre.active) {
			true  -> binding.panel.setCardBackgroundColor(Color.parseColor("#2083ED"))
			false -> binding.panel.setCardBackgroundColor(Color.parseColor("#292929"))
		}
		binding.panel.setOnClickListener {
			when (genre.active) {
				true  -> updateGenre(null)
				false -> updateGenre(genre.genre)
			}
		}
	}

	companion object {

		fun from(
			parent: ViewGroup,
		): GenresViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = GenreItemBinding.inflate(layoutInflater, parent, false)
			return GenresViewHolder(binding)
		}
	}
}