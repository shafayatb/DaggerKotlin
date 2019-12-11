package com.baldystudios.daggerkotlin.ui.main.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.models.Post
import com.baldystudios.daggerkotlin.ui.main.Resource
import com.baldystudios.daggerkotlin.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostsFragment : DaggerFragment() {

    private val TAG = "PostsFragment"

    lateinit var postsViewModel: PostsViewModel

    @Inject
    lateinit var providersFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        postsViewModel = ViewModelProvider(this, providersFactory)
            .get(PostsViewModel::class.java)

        postsViewModel.test()

        subscribeObeservers()

    }

    fun subscribeObeservers() {

        postsViewModel.observePosts().observe(viewLifecycleOwner, Observer<Resource<List<Post>>> {

            it?.let {
                Log.v(TAG, "OnChanged: ${it.data}")
            }

        })

    }

}