package com.baldystudios.daggerkotlin.di.main

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baldystudios.daggerkotlin.network.main.MainApi
import com.baldystudios.daggerkotlin.ui.main.MainActivity
import com.baldystudios.daggerkotlin.ui.main.posts.PostRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
object MainModule {

    @MainScope
    @Provides
    @JvmStatic
    fun providePostAdapter(): PostRecyclerViewAdapter {
        return PostRecyclerViewAdapter()
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideLinearLayoutManager(mainActivity: MainActivity): LinearLayoutManager {
        return LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false)
    }

    @MainScope
    @Provides
    @JvmStatic
    fun provideMainApi(retrofit: Retrofit): MainApi {

        return retrofit.create(MainApi::class.java)

    }

}