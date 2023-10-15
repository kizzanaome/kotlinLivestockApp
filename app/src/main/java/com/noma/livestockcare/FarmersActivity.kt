package com.noma.livestockcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.noma.livestockcare.adapter.ActivityAdapter
import com.noma.livestockcare.fragments.AddFarmerFragment
import com.noma.livestockcare.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FarmersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmers)

        //Opens the add farmer fragment
        val addFarmerButton = findViewById<FloatingActionButton>(R.id.add_farmer)
        addFarmerButton.setOnClickListener{
            supportFragmentManager.beginTransaction().add(R.id.container, AddFarmerFragment()).commit()
        }

        val NavFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView4 )as NavHostFragment
        val controller = NavFragment.navController



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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.add_farmer ->{supportFragmentManager.beginTransaction().add(R.id.container, AddFarmerFragment()).commit()}
        }
        return super.onOptionsItemSelected(item)
    }
}