package com.example.kinoinfo.presentation

import com.example.kinoinfo.ui.MainView
import moxy.MvpPresenter

class MainPresenter(
	private val router: MainRouter
) : MvpPresenter<MainView>() {

	private var newRootCreated = false

	fun newRoot() {
		if (!newRootCreated) {
			router.newRoot()
		}
		newRootCreated = true
	}
}