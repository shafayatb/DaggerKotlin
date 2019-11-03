package com.baldystudios.daggerkotlin

import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sfdkj: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        Log.v("DAGGERINJECT", sfdkj)

    }
}
