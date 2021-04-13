package com.therickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.therickandmorty.ui.characters.CharactersFragment
import com.therickandmorty.ui.episodes.EpisodesFragment
import com.therickandmorty.ui.locations.LocationsFragment
import com.therickandmorty.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager
    private val charactersFragment: CharactersFragment = CharactersFragment()
    private val locationsFragment: LocationsFragment = LocationsFragment()
    private val episodesFragment: EpisodesFragment = EpisodesFragment()
    private val searchFragment: SearchFragment = SearchFragment()

    lateinit var toolbar: ActionBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            toolbar.title = "Character"
            fragmentManager.beginTransaction()
                .add(android.R.id.content, charactersFragment, "1")
                .commit()
        }


    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_characters -> {
                    toolbar.title = "Character"
                    fragmentManager.beginTransaction()
                        .replace(android.R.id.content, charactersFragment)
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_locations -> {
                    toolbar.title = "Location"
                    fragmentManager.beginTransaction()
                        .replace(android.R.id.content, locationsFragment,"2")
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_episodes -> {
                    toolbar.title = "Episodes"
                    fragmentManager.beginTransaction()
                        .replace(android.R.id.content, episodesFragment, "3")
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    toolbar.title = "Search"
                    fragmentManager.beginTransaction()
                        .replace(android.R.id.content, searchFragment, "4")
                        .addToBackStack(null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

//    private fun openFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

}