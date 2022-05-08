package ru.kino.shared.movie.data.datasource

import ru.kino.shared.movie.domain.entity.MovieInformation

interface MovieDataSource {

	suspend fun getMovie(): List<MovieInformation>
}