package com.example.kinoinfo.di

import com.example.kinoinfo.presentation.MainPresenter
import com.example.kinoinfo.ui.buildCicerone
import com.example.kinoinfo.ui.getClient
import com.example.kinoinfo.ui.provideMoshi
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

val appModule = module {
	single { provideMoshi() }
	single { getClient(get()) }
	single { buildCicerone() }
	single { get<Cicerone<Router>>().router }
	single { get<Cicerone<Router>>().getNavigatorHolder() }

	factory {
		MainPresenter(
			get(),
		)
	}
}