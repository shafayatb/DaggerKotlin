package com.baldystudios.daggerkotlin.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.models.User
import com.baldystudios.daggerkotlin.ui.auth.AuthResource
import com.baldystudios.daggerkotlin.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    private val TAG = "ProfileFragment"

    lateinit var profileViewModel: ProfileViewModel

    @Inject
    lateinit var providersFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(TAG, "Profile Fragment was created")

        profileViewModel = ViewModelProvider(this, providersFactory)
            .get(ProfileViewModel::class.java)

        profileViewModel.test()

        subscribeObservers()
    }

    private fun subscribeObservers() {

        profileViewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        profileViewModel.getAuthenticatedUser()
            .observe(viewLifecycleOwner, Observer<AuthResource<User>> {

                it?.let { userAuthResource ->

                    when (userAuthResource::class) {

                        AuthResource.Authenticated::class -> {
                            setUserDetails(userAuthResource.data)
                            Log.d(TAG, "OnChanged: ${userAuthResource.data?.email}")
                        }

                        AuthResource.Error::class -> {
                            setErrorDetails(userAuthResource.message)
                            Log.e(TAG, "OnChanged: ${userAuthResource.message}")
                        }

                        else -> {
                            Log.e(TAG, "OnChanged: Nothing is working")
                        }
                    }

                }

            })
    }

    private fun setErrorDetails(message: String) {

        email.text = message
        username.text = "error"
        website.text = "error"
    }

    private fun setUserDetails(user: User?) {

        email.text = user?.email
        username.text = user?.name
        website.text = user?.website

    }

}