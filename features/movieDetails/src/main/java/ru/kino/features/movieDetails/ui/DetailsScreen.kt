package ru.kino.features.movieDetails.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.kino.shared.movie.domain.entity.MovieInformation

fun getDetailsScreen(movieInformation: MovieInformation) =
	FragmentScreen { DetailsFragment.newInstance(movieInformation) }