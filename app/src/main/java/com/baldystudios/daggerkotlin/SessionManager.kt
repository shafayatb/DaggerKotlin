package com.baldystudios.daggerkotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SessionManager @Inject constructor() {

    private val TAG = "SessionManager"

    private val cachedUser = MediatorLiveData<AuthResource<User>>()

    val authUser: LiveData<AuthResource<User>>
        get() = cachedUser

    fun authenticateId(source: LiveData<AuthResource<User>>) {

        if (cachedUser != null) {
            cachedUser.value = AuthResource.Loading(null)
            cachedUser.addSource(source) {
                cachedUser.value = it
                cachedUser.removeSource(source)
            }
        } else {
            Log.d(TAG, "authenticateId: previous session detected. Retrieving user from cache")
        }
    }

    fun logout() {

        Log.d(TAG, "logout: Logging Out...")

        cachedUser.value = AuthResource.NotAuthenticated()

    }


}

