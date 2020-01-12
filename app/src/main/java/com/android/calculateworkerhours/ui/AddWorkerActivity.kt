package com.android.calculateworkerhours.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.calculateworkerhours.R
import kotlinx.android.synthetic.main.add_worker_activity.*
import kotlinx.android.synthetic.main.add_worker_activity.toolbar

class AddWorkerActivity  : AppCompatActivity() {

    private lateinit var host: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_worker_activity)
        setSupportActionBar(toolbar)

        setupNavController()

        fab2.setOnClickListener { view ->
           save()
        }
    }

    private fun save() {

    }

    private fun setupNavController() {
        host = nav_add_worker_fragment as NavHostFragment
        navController = host.navController
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(R.navigation.add_worker_navigation)
        navController.graph = graph
    }

}