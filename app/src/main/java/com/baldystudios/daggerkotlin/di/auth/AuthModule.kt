package com.baldystudios.daggerkotlin.di.auth

import com.baldystudios.daggerkotlin.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AuthModule {

    @Provides
    @JvmStatic
    fun provideAuthApi(retrofit: Retrofit): AuthApi{

        return retrofit.create(AuthApi::class.java)

    }

}