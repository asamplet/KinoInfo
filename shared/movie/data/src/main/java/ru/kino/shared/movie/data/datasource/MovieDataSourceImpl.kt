package ru.kino.shared.movie.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kino.shared.movie.data.api.MovieApi
import ru.kino.shared.movie.data.mapper.toSingle
import ru.kino.shared.movie.domain.entity.MovieInformation

class MovieDataSourceImpl(
	private val api: MovieApi
) : MovieDataSource {

	override suspend fun getMovie(): List<MovieInformation> =
		withContext(Dispatchers.IO) {
			api.getMovie().toSingle()
		}
}