package com.baldystudios.daggerkotlin.di.main

import com.baldystudios.daggerkotlin.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainFragmentBuildersModule {


    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

}