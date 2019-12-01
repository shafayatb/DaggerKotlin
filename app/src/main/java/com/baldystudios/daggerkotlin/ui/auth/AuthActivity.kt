package com.baldystudios.daggerkotlin.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.ui.main.MainActivity
import com.baldystudios.daggerkotlin.viewmodels.ViewModelProvidersFactory
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    val TAG = "AuthActivity"

    lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authViewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()

        button.setOnClickListener {
            attemptLogin()
        }

        subscribeObservers()

    }

    private fun subscribeObservers() {

        authViewModel.observeAuthState().observe(this, Observer<AuthResource<User>> {

            it?.let { userAuthResource ->

                when (userAuthResource::class) {

                    AuthResource.Loading::class -> {
                        showProgressBar(true)
                    }

                    AuthResource.Authenticated::class-> {
                        showProgressBar(false)
                        onLoginSuccess()
                        Log.d(TAG, "OnChanged: ${userAuthResource.data?.email}")
                    }

                    AuthResource.Error::class -> {
                        showProgressBar(false)
                        Log.e(TAG, "OnChanged: ${userAuthResource.message}")
                    }

                    AuthResource.NotAuthenticated::class -> {
                        showProgressBar(false)
                    }
                    else -> {
                        Log.e(TAG, "OnChanged: Nothing is working")
                    }
                }

            }

        })

    }

    private fun onLoginSuccess(){

        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    private fun showProgressBar(isVisible: Boolean) {

        if (isVisible) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE

    }

    private fun setLogo() {
        requestManager.load(logo).into(login_banner)
    }


    private fun attemptLogin() {

        if (TextUtils.isEmpty(username.text.toString())) {
            return
        }

        authViewModel.authenticateWithUserId(username.text.toString().toInt())

    }
}
