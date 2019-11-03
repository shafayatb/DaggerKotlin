package com.baldystudios.daggerkotlin.di

import android.app.Application
import dagger.Module
import dagger.Provides


@Module
object AppModule {

    @JvmStatic
    @Provides
    fun someString(): String = "This is a test string"

    @JvmStatic
    @Provides
    fun getApp(application: Application): Boolean {
        return application == null
    }

}