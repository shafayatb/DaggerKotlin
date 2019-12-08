package com.baldystudios.daggerkotlin.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.baldystudios.daggerkotlin.R
import dagger.android.support.DaggerFragment

class ProfileFragment : DaggerFragment() {

    private val TAG = "ProfileFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(activity, TAG, Toast.LENGTH_LONG).show()


        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}