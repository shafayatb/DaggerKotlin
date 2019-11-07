package com.baldystudios.daggerkotlin.di

import androidx.lifecycle.ViewModelProvider
import com.baldystudios.daggerkotlin.viewmodels.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelProviderFactory(modelProvidersFactory: ViewModelProvidersFactory): ViewModelProvider.Factory




}