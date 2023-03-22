package com.example.rental

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        val navHostFragment = supportFragmentManager. findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        val navView = findViewById<BottomNavigationView>(R.id.nav_bottom)
        NavigationUI.setupWithNavController(navView,navController)
    }
}