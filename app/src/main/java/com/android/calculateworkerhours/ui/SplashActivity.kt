package com.android.calculateworkerhours.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.android.calculateworkerhours.R

class SplashActivity : AppCompatActivity() {

    private lateinit var host: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupNavController()
    }

    private fun setupNavController() {
        host = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_splash) as NavHostFragment? ?: return
    }

}