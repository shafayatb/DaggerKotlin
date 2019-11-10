package com.baldystudios.daggerkotlin.ui.auth


sealed class AuthResource<T>(
    val authStatus: AuthStatus? = null,
    val data: T? = null,
    val message: String = ""
) {
    class Authenticated<T>(data: T?) : AuthResource<T>(AuthStatus.AUTHENTICATED, data)
    class Loading<T>(data: T? = null) : AuthResource<T>(AuthStatus.LOADING, data)
    class Error<T>(message: String, data: T? = null) :
        AuthResource<T>(AuthStatus.ERROR, data, message)

    class NotAuthenticated<T> : AuthResource<T>(AuthStatus.NOT_AUTHENTICATED)

    public enum class AuthStatus { AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED }
}


