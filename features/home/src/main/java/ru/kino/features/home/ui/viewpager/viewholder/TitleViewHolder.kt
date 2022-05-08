package ru.kino.features.home.ui.viewpager.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kino.features.home.R
import ru.kino.features.home.databinding.TitleItemBinding
import ru.kino.features.home.presentation.MovieContent

class TitleViewHolder(
	private val binding: TitleItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		title: MovieContent.Title
	) {
		binding.title.text =
			when (title) {
				MovieContent.GenresTitle -> itemView.context.getString(R.string.genres)
				MovieContent.MovieTitle  -> itemView.context.getString(R.string.title)
			}
	}

	companion object {

		fun from(
			parent: ViewGroup,
		): TitleViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = TitleItemBinding.inflate(layoutInflater, parent, false)
			return TitleViewHolder(binding)
		}
	}
}