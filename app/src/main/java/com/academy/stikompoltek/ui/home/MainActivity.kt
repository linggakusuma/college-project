package com.academy.stikompoltek.ui.home

import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.academy.stikompoltek.R
import com.academy.stikompoltek.data.base.BaseActivity
import com.academy.stikompoltek.databinding.ActivityMainBinding
import com.academy.stikompoltek.utils.ext.setTransparentStatusBar
import com.academy.stikompoltek.utils.ext.setTransparentStatusBarBlack

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun subscribeUi() {
        super.subscribeUi()
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment).apply {
            addOnDestinationChangedListener { _, destination, _ ->
                this@MainActivity.supportActionBar?.title = destination.label
                when (destination.id) {
                    R.id.home_fragment -> setTransparentStatusBar()
                    else -> setTransparentStatusBarBlack()
                }
            }
        }

        binding.bottomNavBar.setupWithNavController(navController)
    }


}
