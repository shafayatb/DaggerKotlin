package com.baldystudios.daggerkotlin.network.main

import com.baldystudios.daggerkotlin.models.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query


interface MainApi {

    // /posts?userId=1

    @GET("posts")
    fun getPostsFromUser(@Query("userId") id: Int): Flowable<List<Post>>

}