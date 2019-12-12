package com.baldystudios.daggerkotlin.ui.main.posts

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.models.Post
import com.baldystudios.daggerkotlin.utils.inflate
import kotlinx.android.synthetic.main.layout_post_list_item.view.*

class PostRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var postList = arrayListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PostViewHolder(parent.inflate(R.layout.layout_post_list_item, false))

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as PostViewHolder).bind(postList[position])
    }

    fun setPosts(postList: List<Post>) {
        this.postList = ArrayList(postList)
        notifyDataSetChanged()
    }


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post) {
            itemView.title.text = post.title
        }

    }
}