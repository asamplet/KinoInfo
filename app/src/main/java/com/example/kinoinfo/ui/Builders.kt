package com.example.kinoinfo.ui

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun buildCicerone(): Cicerone<Router> =
	Cicerone.create()

fun getClient(moshi: Moshi): Retrofit = Retrofit.Builder()
	.addConverterFactory(MoshiConverterFactory.create(moshi))
	.baseUrl("https://s3-eu-west-1.amazonaws.com/")
	.build()

fun provideMoshi(): Moshi = Moshi.Builder()
	.addLast(KotlinJsonAdapterFactory())
	.build()