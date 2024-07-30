package com.example.stellarexplorer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.stellarexplorer.fragments.AddEventDialogFragment
import com.example.stellarexplorer.fragments.CelestialBodyFragment
import com.example.stellarexplorer.fragments.ConstellationsFragment
import com.example.stellarexplorer.fragments.UpcomingEventsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(CelestialBodyFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_view_celestial_bodies -> {
                replaceFragment(CelestialBodyFragment())
                true
            }
            R.id.action_upcoming_events -> {
                replaceFragment(UpcomingEventsFragment())
                true
            }
            R.id.action_constellations -> {
                replaceFragment(ConstellationsFragment())
                true
            }
            R.id.action_add_event -> {
                val addEventDialogFragment = AddEventDialogFragment()
                addEventDialogFragment.show(supportFragmentManager, "add_event")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}