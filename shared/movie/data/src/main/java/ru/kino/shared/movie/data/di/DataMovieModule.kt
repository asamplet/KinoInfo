package ru.kino.shared.movie.data.di

import org.koin.dsl.module
import retrofit2.Retrofit
import ru.kino.shared.movie.data.api.MovieApi
import ru.kino.shared.movie.data.datasource.MovieDataSource
import ru.kino.shared.movie.data.datasource.MovieDataSourceImpl
import ru.kino.shared.movie.data.repository.MovieRepositoryImpl
import ru.kino.shared.movie.domain.repository.MovieRepository

val dataMovieModule = module {
	factory<MovieDataSource> { MovieDataSourceImpl(get()) }
	factory<MovieRepository> { MovieRepositoryImpl(get()) }
	factory { get<Retrofit>().create(MovieApi::class.java) }
}