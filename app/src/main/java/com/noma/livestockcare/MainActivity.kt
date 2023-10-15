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
//
//        val farmersCard = findViewById<CardView>(R.id.workers_card)
//        farmersCard.setOnClickListener{
////            val NavFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView4 )as NavHostFragment
////
////            controller.add(R.id.frameLayout, mFragment).commit()
//
//
////            var intent = Intent(this,FarmersActivity::class.java)
////            startActivity(intent)
//
//
//        }

//        val products = findViewById<CardView>(R.id.products_card)
//        products.setOnClickListener{
//            var intent = Intent(this,ProductsActivity::class.java)
//            startActivity(intent)
//        }


    }



}