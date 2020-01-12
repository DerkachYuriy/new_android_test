package com.android.calculateworkerhours.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.calculateworkerhours.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var host: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupNavController()

        fab.setOnClickListener { view ->
            moveToAddWorkerActivity()
        }
    }

    private fun moveToAddWorkerActivity() {
        navController.navigate(R.id.action_workersList_to_addWorkerActivity)
    }

    private fun setupNavController() {
        host = nav_main_fragment as NavHostFragment
        navController = host.navController
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(R.navigation.workers_list_navigation)
        navController.graph = graph
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
