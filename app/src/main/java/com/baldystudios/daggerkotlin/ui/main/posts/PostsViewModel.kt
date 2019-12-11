package com.baldystudios.daggerkotlin.ui.main.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.SessionManager
import com.baldystudios.daggerkotlin.network.main.MainApi
import javax.inject.Inject

class PostsViewModel @Inject constructor(val mainApi: MainApi, val sessionManager: SessionManager): ViewModel() {


    val TAG = "PostsViewModel"

    fun test() {
        Log.v(TAG, "Posts View Model was created")
    }


}