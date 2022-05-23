package ru.kino.shared.movie.domain.usecase

import ru.kino.shared.movie.domain.entity.MovieInformation
import ru.kino.shared.movie.domain.repository.MovieRepository

class GetMovieUseCase(
	private val movieRepository: MovieRepository
) {

	suspend operator fun invoke(): List<MovieInformation> =
		movieRepository.getMovie()
}