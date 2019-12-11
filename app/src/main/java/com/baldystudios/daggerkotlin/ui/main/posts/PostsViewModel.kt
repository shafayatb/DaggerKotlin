package com.baldystudios.daggerkotlin.ui.main.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.baldystudios.daggerkotlin.SessionManager
import com.baldystudios.daggerkotlin.models.Post
import com.baldystudios.daggerkotlin.network.main.MainApi
import com.baldystudios.daggerkotlin.ui.main.Resource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsViewModel @Inject constructor(val mainApi: MainApi, val sessionManager: SessionManager) :
    ViewModel() {

    val TAG = "PostsViewModel"

    private var posts = MediatorLiveData<Resource<List<Post>>>()

    fun test() {
        Log.v(TAG, "Posts View Model was created")
    }

    fun observePosts(): LiveData<Resource<List<Post>>> {

        if (posts != null) {

            posts = MediatorLiveData()

            posts.setValue(Resource.Loading(null))

            val source = LiveDataReactiveStreams.fromPublisher<Resource<List<Post>>>(
                mainApi.getPostsFromUser(sessionManager.authUser.value?.data?.id!!)
                    .onErrorReturn {
                        Log.e(TAG, "apply: ", it)
                        val post = Post()
                        post.id = -1
                        val postList = ArrayList<Post>()
                        postList.add(post)
                        postList
                    }.map(Function<List<Post>, Resource<List<Post>>> {

                        if (it.isNotEmpty()) {
                            if (it[0].id == -1) {
                                return@Function Resource.Error("Something went wrong", null)
                            }
                        }

                        Resource.Success(it)

                    }).subscribeOn(Schedulers.io())
            )

            posts.addSource(source) {
                posts.value = it
                posts.removeSource(source)
            }
        }

        return posts
    }


}