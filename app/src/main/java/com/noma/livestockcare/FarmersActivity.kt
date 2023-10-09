package com.noma.livestockcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noma.livestockcare.data.ActivityAdapter
import com.noma.livestockcare.data.ActivityModel
import com.noma.livestockcare.data.LivestockResponse
import com.noma.livestockcare.data.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FarmersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmers)


//        list.add(ActivityModel(R.drawable.avatar_2, "Douglas Kato", "Worker"))
//        list.add(ActivityModel(R.drawable.avatar_2, "Noma Naome", "Administrator"))
//        list.add(ActivityModel(R.drawable.third, "Magret Manrol", "Farmer"))
//        list.add(ActivityModel(R.drawable.avatar_2, "Kiwatule Davis", "Sales Manager"))
//        list.add(ActivityModel(R.drawable.forth, "Abraham Katula", "Products Manager"))

        val activityAdapter = ActivityAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.workers_recycler_view)
        recyclerView.adapter = activityAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
//
        CoroutineScope(Dispatchers.IO).launch {

            val apiService = RetrofitInstance().createRetrofit()
            val apiResponse = apiService.getWorkers()

            val users = apiResponse.response

            withContext(Dispatchers.Main) {
                activityAdapter.setUsers(users)
            }
        }

    }
}