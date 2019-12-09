package com.baldystudios.daggerkotlin.ui.main.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(): ViewModel() {

    val TAG = "ProfileViewModel"

    fun test(){
        Log.v(TAG, "Profile View Model was created")
    }

}