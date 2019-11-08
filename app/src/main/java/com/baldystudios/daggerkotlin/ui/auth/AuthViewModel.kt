package com.baldystudios.daggerkotlin.ui.auth


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi) : ViewModel() {

    val TAG = "AuthViewModel"

    private val authUser = MediatorLiveData<User>()

    fun authenticateWithUserId(userId: Int) {
        val source: LiveData<User> = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
        )


        authUser.addSource(source) {
            Log.d(TAG, "Please Work")
            authUser.value = it!!
            authUser.removeSource(source)
        }


    }

    fun observeUser(): LiveData<User> {
        return authUser
    }

}