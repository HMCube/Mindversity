package com.app.mindversity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

// MainActivity.kt
class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(MindfullnessFragment())
        bottomNav = findViewById(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_mindfullness -> {
                    loadFragment(MindfullnessFragment())
                    true
                }

                R.id.nav_wellness -> {
                    loadFragment(WellnessFragment())
                    true
                }

                R.id.nav_health -> {
                    loadFragment(HealthFragment())
                    true
                }

                else -> false
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}





