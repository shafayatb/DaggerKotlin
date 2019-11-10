package com.baldystudios.daggerkotlin.ui.auth


import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.network.auth.AuthApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi) : ViewModel() {

    val TAG = "AuthViewModel"

    private val authUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithUserId(userId: Int) {

        authUser.value = AuthResource.Loading(null)

        val source = LiveDataReactiveStreams.fromPublisher<AuthResource<User>>(
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


        authUser.addSource(source) {

            authUser.value = it
            authUser.removeSource(source)
        }


    }

    fun observeUser(): LiveData<AuthResource<User>> {
        return authUser
    }

}