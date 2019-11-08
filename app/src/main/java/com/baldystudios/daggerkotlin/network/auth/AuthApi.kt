package com.baldystudios.daggerkotlin.network.auth

import com.baldystudios.daggerkotlin.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>

}