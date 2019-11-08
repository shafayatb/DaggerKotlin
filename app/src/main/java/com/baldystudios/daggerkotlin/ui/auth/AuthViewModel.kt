package com.baldystudios.daggerkotlin.ui.auth

import android.util.Log

import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.network.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi):ViewModel() {

    val TAG = "AuthViewModel"

    fun checkAuthApi(){

        authApi.getUser(1).toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<User> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(user: User) {
                    Log.d(TAG, "OnNext: " + user.email)
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onError: " + e.localizedMessage)
                }
            })
    }

}