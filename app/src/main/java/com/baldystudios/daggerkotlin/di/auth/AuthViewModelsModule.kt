package com.baldystudios.daggerkotlin.di.auth

import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.di.ViewModelKey
import com.baldystudios.daggerkotlin.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bingAuthViewModel(viewModel: AuthViewModel): ViewModel

}