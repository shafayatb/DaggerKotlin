package com.baldystudios.daggerkotlin.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.SessionManager
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.ui.auth.AuthResource
import javax.inject.Inject

class ProfileViewModel @Inject constructor(val sessionManager: SessionManager) : ViewModel() {

    val TAG = "ProfileViewModel"

    fun test() {
        Log.v(TAG, "Profile View Model was created")
    }


    fun getAuthenticatedUser(): LiveData<AuthResource<User>> {
        return sessionManager.authUser
    }

}