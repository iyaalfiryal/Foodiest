package com.veronica.idn.foodiest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.fragment.FavoriteFragment
import com.veronica.idn.foodiest.fragment.HomeFragment
import com.veronica.idn.foodiest.fragment.LocationFragment
import com.veronica.idn.foodiest.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val home_fragment = HomeFragment()
                    addFragment(home_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_location -> {
                    val location_fragment = LocationFragment()
                    addFragment(location_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_favorite -> {
                    val favorite_fragment = FavoriteFragment()
                    addFragment(favorite_fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    val profile_fragment = ProfileFragment()
                    addFragment(profile_fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm_main_container, fragment, fragment::class.java.simpleName)
            .addToBackStack(null).commit()
    }

    val defaultMainView = HomeFragment.defaultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        nav_main.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        addFragment(defaultMainView)
    }
}
