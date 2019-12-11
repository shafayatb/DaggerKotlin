package com.baldystudios.daggerkotlin.di.main

import com.baldystudios.daggerkotlin.network.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
object MainModule {

    @Provides
    @JvmStatic
    fun provideMainApi(retrofit: Retrofit): MainApi {

        return retrofit.create(MainApi::class.java)

    }

}