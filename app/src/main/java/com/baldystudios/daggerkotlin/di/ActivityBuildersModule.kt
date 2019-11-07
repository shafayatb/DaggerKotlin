package com.baldystudios.daggerkotlin.di

import com.baldystudios.daggerkotlin.di.auth.AuthViewModelsModule
import com.baldystudios.daggerkotlin.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class]
    )
    abstract fun contributesAuthActiity(): AuthActivity


}