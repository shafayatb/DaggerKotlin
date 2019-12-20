package com.baldystudios.daggerkotlin.ui.main.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.models.Post
import com.baldystudios.daggerkotlin.ui.main.Resource
import com.baldystudios.daggerkotlin.utils.VerticalSpaceItemDecoration
import com.baldystudios.daggerkotlin.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject
import javax.inject.Provider

class PostsFragment : DaggerFragment() {

    private val TAG = "PostsFragment"

    lateinit var postsViewModel: PostsViewModel

    @Inject
    lateinit var postRecyclerViewAdapter: PostRecyclerViewAdapter

    @Inject
    lateinit var linearLayoutManager: Provider<LinearLayoutManager>

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

        initRecyclerView()
        subscribeObeservers()

    }

    fun subscribeObeservers() {

        postsViewModel.observePosts().observe(viewLifecycleOwner, Observer<Resource<List<Post>>> {

            it?.let {
                Log.v(TAG, "OnChanged: ${it.data}")
                when (it) {

                    is Resource.Loading -> {
                        Log.d(TAG, "OnChange: LOADING...")
                    }

                    is Resource.Success -> {
                        Log.d(TAG, "OnChange: got posts....")
                        it.data?.let { postList ->
                            postRecyclerViewAdapter.setPosts(postList)
                        }

                    }

                    is Resource.Error -> {
                        Log.e(TAG, "OnChange: ${it.message}")
                    }

                }
            }

        })

    }

    fun initRecyclerView() {

        recycler_view.layoutManager = linearLayoutManager.get()
        recycler_view.addItemDecoration(VerticalSpaceItemDecoration(15))
        recycler_view.adapter = postRecyclerViewAdapter

    }

}