package com.baldystudios.daggerkotlin.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.baldystudios.daggerkotlin.BaseActivity
import com.baldystudios.daggerkotlin.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navController)

        nav_view.setNavigationItemSelectedListener(this)

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

            android.R.id.home -> {
                return if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    true
                } else {
                    false
                }
            }

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {

        when (menu.itemId) {

            R.id.nav_profile -> {

                val navOptions = NavOptions.Builder().setPopUpTo(R.id.main, true).build()

                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(
                        R.id.profileScreen,
                        null,
                        navOptions
                    )
            }

            R.id.nav_posts -> {
                if (isValidDestination(R.id.postsScreen)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.postsScreen)
                }
            }

        }

        menu.isChecked = true
        drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }

    private fun isValidDestination(destination: Int): Boolean {
        return destination != Navigation.findNavController(this, R.id.nav_host_fragment)
            .currentDestination?.id
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation
                .findNavController(this, R.id.nav_host_fragment), drawer_layout
        )
    }

}
