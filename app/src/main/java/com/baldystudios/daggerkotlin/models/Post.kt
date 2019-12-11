package com.baldystudios.daggerkotlin.models

data class Post(
    var userId: Int? = null,
    var id: Int? = null,
    var title: String? = null,
    var body: String? = null
)