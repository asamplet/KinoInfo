package com.example.kinoinfo.ui

import android.os.Bundle
import com.example.kinoinfo.R
import com.example.kinoinfo.presentation.MainPresenter
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : MvpAppCompatActivity(), MainView {

	private val navigatorHolder: NavigatorHolder by inject()
	private val navigator = AppNavigator(this, R.id.container)

	@InjectPresenter
	lateinit var presenter: MainPresenter

	@ProvidePresenter
	fun provide(): MainPresenter = get()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onResume() {
		super.onResume()
		navigatorHolder.setNavigator(navigator)
		presenter.newRoot()
	}

	override fun onPause() {
		super.onPause()
		navigatorHolder.removeNavigator()
	}
}