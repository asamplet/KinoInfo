package ru.kino.shared.movie.data.api

import retrofit2.http.GET
import ru.kino.shared.movie.data.dto.FilmListDto
import ru.kino.shared.movie.data.dto.MovieInformationDto

interface MovieApi {

	@GET("sequeniatesttask/films.json")
	suspend fun getMovie(): FilmListDto
}