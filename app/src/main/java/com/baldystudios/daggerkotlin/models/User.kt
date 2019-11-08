package com.baldystudios.daggerkotlin.models

data class User(
    val address: Address? = null,
    val company: Company? = null,
    val email: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val phone: String? = null,
    val username: String? = null,
    val website: String? = null
)

data class Geo(
    val lat: String? = null,
    val lng: String? = null
)

data class Company(
    val bs: String? = null,
    val catchPhrase: String? = null,
    val name: String? = null
)

data class Address(
    val city: String? = null,
    val geo: Geo? = null,
    val street: String? = null,
    val suite: String? = null,
    val zipcode: String? = null
)