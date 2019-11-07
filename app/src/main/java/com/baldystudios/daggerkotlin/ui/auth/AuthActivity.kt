package com.baldystudios.daggerkotlin.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.viewmodels.ViewModelProvidersFactory
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {


    lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    @Inject
    lateinit var logo:Drawable

    @Inject
    lateinit var requestManager: RequestManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authViewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        authViewModel.checkViewModel()

        setLogo()

    }

    private fun setLogo(){
        requestManager.load(logo).into(login_banner)
    }
}
