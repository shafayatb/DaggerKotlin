package com.baldystudios.daggerkotlin.di

import com.baldystudios.daggerkotlin.di.auth.AuthModule
import com.baldystudios.daggerkotlin.di.auth.AuthScope
import com.baldystudios.daggerkotlin.di.auth.AuthViewModelsModule
import com.baldystudios.daggerkotlin.di.main.MainFragmentBuildersModule
import com.baldystudios.daggerkotlin.di.main.MainModule
import com.baldystudios.daggerkotlin.di.main.MainScope
import com.baldystudios.daggerkotlin.di.main.ProfileViewModelModule
import com.baldystudios.daggerkotlin.ui.auth.AuthActivity
import com.baldystudios.daggerkotlin.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class, AuthModule::class]
    )
    abstract fun contributesAuthActiity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainFragmentBuildersModule::class, ProfileViewModelModule::class, MainModule::class]
    )
    abstract fun contributesMainActiity(): MainActivity
}