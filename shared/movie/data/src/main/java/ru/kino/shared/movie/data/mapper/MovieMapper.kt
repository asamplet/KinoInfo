package ru.kino.shared.movie.data.mapper

import ru.kino.shared.movie.data.dto.FilmListDto
import ru.kino.shared.movie.data.dto.MovieInformationDto
import ru.kino.shared.movie.domain.entity.MovieInformation

fun FilmListDto.toSingle() = films.map{ it.toEntity() }

fun MovieInformationDto.toEntity() = MovieInformation(id, localizedName, name, year, rating, imageUrl, description, genres)