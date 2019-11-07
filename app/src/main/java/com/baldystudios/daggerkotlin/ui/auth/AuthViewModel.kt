package com.baldystudios.daggerkotlin.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor():ViewModel() {

    fun checkViewModel(){
        Log.v("AuthViewModel","Injection is working")
    }

}