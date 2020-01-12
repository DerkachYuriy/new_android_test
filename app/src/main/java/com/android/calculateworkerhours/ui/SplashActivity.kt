package com.android.calculateworkerhours.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.calculateworkerhours.R

class SplashActivity : AppCompatActivity() {

    private lateinit var host: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupNavController()

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {

            }
        }
    }

    private fun setupNavController() {
        host = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_splash) as NavHostFragment? ?: return

        navController = host.navController
    }

}