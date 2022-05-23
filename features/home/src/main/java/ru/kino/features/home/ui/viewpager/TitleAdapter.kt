package ru.kino.features.home.ui.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kino.features.home.R
import ru.kino.features.home.databinding.TitleItemBinding

class TitleAdapter(private val title: String): RecyclerView.Adapter<TitleAdapter.TitleViewHolder>(){

	class TitleViewHolder(binding: TitleItemBinding): RecyclerView.ViewHolder(binding.root) {
		val title = binding.title
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding = TitleItemBinding.inflate(layoutInflater, parent, false)
		return TitleViewHolder(binding)
	}

	override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
		holder.title.text = title
	}

	override fun getItemCount(): Int = 1

	override fun getItemViewType(position: Int): Int = R.layout.title_item
}