package com.baldystudios.daggerkotlin.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.network.auth.AuthApi
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi):ViewModel() {

    val TAG = "AuthViewModel"

    fun checkAuthApi(){

        if(authApi == null) Log.d(TAG, "auth api is NULL") else Log.d(TAG, "auth api is NOT NULL")
    }

}