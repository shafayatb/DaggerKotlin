package com.baldystudios.daggerkotlin.ui.auth


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.SessionManager
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.network.auth.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi, val sessionManager: SessionManager) :
    ViewModel() {

    val TAG = "AuthViewModel"

    fun authenticateWithUserId(userId: Int) {

        Log.d(TAG, "Attempting to login...")

        sessionManager.authenticateId(queryUserId(userId))


    }

    private fun queryUserId(userId: Int): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher<AuthResource<User>>(
            authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
                .onErrorReturn {
                    val errorUser = User()
                    errorUser.id = -1
                    errorUser
                }.map(Function<User, AuthResource<User>> {

                    if (it.id == -1) {
                        return@Function AuthResource.Error("Could Not Authenticate", null)
                    }
                    AuthResource.Authenticated(it)

                })
        )
    }

    fun observeAuthState(): LiveData<AuthResource<User>> {
        return sessionManager.authUser
    }

}