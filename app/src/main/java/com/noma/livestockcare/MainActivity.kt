package com.noma.livestockcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.noma.livestockcare.data.ActivityAdapter
import com.noma.livestockcare.data.ActivityModel
import com.noma.livestockcare.data.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val farmersCard = findViewById<CardView>(R.id.workers_card)
        farmersCard.setOnClickListener{
            var intent = Intent(this,FarmersActivity::class.java)
            startActivity(intent)
        }

        val products = findViewById<CardView>(R.id.products_card)
        products.setOnClickListener{
            var intent = Intent(this,ProductsActivity::class.java)
            startActivity(intent)
        }

//        CoroutineScope(Dispatchers.IO).launch {
//            val service = RetrofitInstance().createRetrofit()
//            val apiResponse = service.getWorkers()
//
//            withContext(Dispatchers.Main) {
//                val workerName = findViewById<TextView>(R.id.footer_name)
//                workerName.text = apiResponse.message
//
////                workerName.text = apiResponse.response[0].f_name
////                workerName.text = apiResponse.toString()
//            }
//        }

    }
}