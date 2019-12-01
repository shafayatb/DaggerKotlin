package com.baldystudios.daggerkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.ui.auth.AuthActivity
import com.baldystudios.daggerkotlin.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    val TAG = "BaseActivity"

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribeObservers()

    }

    private fun subscribeObservers() {
        sessionManager.authUser.observe(this, Observer<AuthResource<User>> {
            it?.let { userAuthResource ->

                when (userAuthResource::class) {

                    AuthResource.Loading::class -> {

                    }

                    AuthResource.Authenticated::class -> {
                        Log.d(TAG, "OnChanged: ${userAuthResource.data?.email}")
                    }

                    AuthResource.Error::class -> {
                        Log.e(TAG, "OnChanged: ${userAuthResource.message}")
                    }

                    AuthResource.NotAuthenticated::class -> {
                        navLoginScreen()
                    }
                    else -> {
                        Log.e(TAG, "OnChanged: Nothing is working")
                    }
                }

            }
        })
    }

    private fun navLoginScreen() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()

    }
}