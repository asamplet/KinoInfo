package com.example.kinoinfo

import android.app.Application
import com.example.kinoinfo.di.appModule
import com.example.kinoinfo.di.routerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.kino.features.home.di.homeModule
import ru.kino.features.movieDetails.di.detailsModule
import ru.kino.shared.movie.data.di.dataMovieModule
import ru.kino.shared.movie.domain.di.domainMovieModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)
			modules(
				appModule,
				routerModule,
				domainMovieModule,
				dataMovieModule,
				homeModule,
				detailsModule,
			)
		}
	}
}