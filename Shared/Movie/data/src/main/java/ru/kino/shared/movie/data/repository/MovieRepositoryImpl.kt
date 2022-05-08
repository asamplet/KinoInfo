package ru.kino.shared.movie.data.repository

import ru.kino.shared.movie.data.datasource.MovieDataSource
import ru.kino.shared.movie.domain.entity.MovieInformation
import ru.kino.shared.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
	private val movieDataSource: MovieDataSource
) : MovieRepository {

	override suspend fun getMovie(): List<MovieInformation> =
		movieDataSource.getMovie()
}