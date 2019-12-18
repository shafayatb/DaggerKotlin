package com.baldystudios.daggerkotlin.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

//fun <T> MutableList<T>.randomList(size:Int){
//    val copy = LinkedList<T>(this)
//    shuffle(copy)
//    this.clear()
//    this.addAll(copy.subList(0,size))
//}