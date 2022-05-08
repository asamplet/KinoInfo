package ru.kino.features.home.ui.viewpager.viewholder

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kino.features.home.databinding.GenreItemBinding
import ru.kino.features.home.presentation.MovieContent

class GenresViewHolder(
	private val binding: GenreItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		movieContent: MovieContent,
		updateGenre: (String?) -> Unit,
	) {
		val genres = movieContent as MovieContent.Genres
		binding.genreTitle.text = genres.genre
		when (genres.active) {
			true  -> binding.panel.setCardBackgroundColor(Color.parseColor("#2083ED"))
			false -> binding.panel.setCardBackgroundColor(Color.parseColor("#292929"))
		}
		binding.panel.setOnClickListener {
			when (genres.active) {
				true  -> updateGenre(null)
				false -> updateGenre(genres.genre)
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