package com.baldystudios.daggerkotlin.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.baldystudios.daggerkotlin.BaseActivity
import com.baldystudios.daggerkotlin.R
import com.baldystudios.daggerkotlin.ui.main.posts.PostsFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

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

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {

        when (menu.itemId) {

            R.id.nav_profile -> {

            }

            R.id.nav_posts -> {

            }

        }

        menu.isChecked = true
        drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }

}
