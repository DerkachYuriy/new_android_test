package com.android.calculateworkerhours.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.calculateworkerhours.R
import com.android.calculateworkerhours.ui.workersList.WorkersViewModel

import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var host: NavHostFragment
    private lateinit var navController: NavController

    val workersListViewModel: WorkersViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavController()
    }

    fun moveToAddWorkerActivity(v: View) {
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
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
