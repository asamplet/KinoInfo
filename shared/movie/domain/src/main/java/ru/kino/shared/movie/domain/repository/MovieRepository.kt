package ru.kino.shared.movie.domain.repository

import ru.kino.shared.movie.domain.entity.MovieInformation

interface MovieRepository {

	suspend fun getMovie(): List<MovieInformation>
}