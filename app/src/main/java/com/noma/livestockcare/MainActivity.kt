package com.noma.livestockcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NavFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView4 )as NavHostFragment
        val controller = NavFragment.navController
    }



}