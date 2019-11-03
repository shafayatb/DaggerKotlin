package com.baldystudios.daggerkotlin.di

import com.baldystudios.daggerkotlin.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesAuthActiity(): AuthActivity


}