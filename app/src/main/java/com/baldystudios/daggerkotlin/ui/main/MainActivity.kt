package com.baldystudios.daggerkotlin.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.baldystudios.daggerkotlin.BaseActivity
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.ui.main.posts.PostsFragment
import com.baldystudios.daggerkotlin.ui.main.profile.ProfileFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testFragment()

    }

    private fun testFragment() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, PostsFragment())
            .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {

            R.id.menu_logout -> {
                sessionManager.logout()
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }

}
