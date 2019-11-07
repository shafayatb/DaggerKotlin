package com.baldystudios.daggerkotlin.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.baldystudios.daggerkotlin.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton


@Module
object AppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {

        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)

    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideAppDrawable(application: Application): Drawable {

        return ContextCompat.getDrawable(application, R.drawable.feature_image)!!

    }

}