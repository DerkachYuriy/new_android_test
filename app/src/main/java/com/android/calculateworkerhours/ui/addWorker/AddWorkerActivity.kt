package com.android.calculateworkerhours.ui.addWorker

import android.os.Bundle
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.calculateworkerhours.R
import com.android.calculateworkerhours.ui.BaseActivity
import kotlinx.android.synthetic.main.add_worker_activity.*

class AddWorkerActivity : BaseActivity() {

    private lateinit var host: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_worker_activity)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupNavController()
    }

    override fun getProgressBar(): ProgressBar {
        return progressBar
    }

    private fun setupNavController() {
        host = nav_add_worker_fragment as NavHostFragment
        navController = host.navController
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(R.navigation.add_worker_navigation)
        navController.graph = graph
    }

}