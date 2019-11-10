package com.baldystudios.daggerkotlin.di

import android.app.Application
import com.baldystudios.daggerkotlin.BaseApplication
import com.baldystudios.daggerkotlin.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    fun sessionManager():SessionManager

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}