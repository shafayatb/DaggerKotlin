package com.baldystudios.daggerkotlin.di

import com.baldystudios.daggerkotlin.di.auth.AuthModule
import com.baldystudios.daggerkotlin.di.auth.AuthViewModelsModule
import com.baldystudios.daggerkotlin.di.main.MainFragmentBuildersModule
import com.baldystudios.daggerkotlin.di.main.ProfileViewModelModule
import com.baldystudios.daggerkotlin.ui.auth.AuthActivity
import com.baldystudios.daggerkotlin.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class, AuthModule::class]
    )
    abstract fun contributesAuthActiity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [MainFragmentBuildersModule::class, ProfileViewModelModule::class]
    )
    abstract fun contributesMainActiity(): MainActivity
}