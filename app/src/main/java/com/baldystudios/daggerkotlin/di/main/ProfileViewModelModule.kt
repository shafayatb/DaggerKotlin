package com.baldystudios.daggerkotlin.di.main

import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.di.ViewModelKey
import com.baldystudios.daggerkotlin.ui.main.posts.PostsViewModel
import com.baldystudios.daggerkotlin.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel

}