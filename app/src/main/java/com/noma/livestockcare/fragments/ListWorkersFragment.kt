package com.noma.livestockcare.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.noma.livestockcare.R
import com.noma.livestockcare.adapter.ActivityAdapter
import com.noma.livestockcare.model.DBBuilder
import com.noma.livestockcare.model.WorkersModel
import com.noma.livestockcare.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListWorkersFragment : Fragment() {

    var list: List<WorkersModel> ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /** Inflate the layout for this fragment */
        val inflater = inflater.inflate(R.layout.fragment_list_workers, container, false)
        inflater.findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE

        val backButton = inflater.findViewById<ImageView>(R.id.arrowback)

        backButton.setOnClickListener{
            findNavController().navigate(R.id.action_listWorkersFragment_to_myHomeFragment)
        }

        /** Floating button that navigates to adding a single worker **/
        val addFarmerButton = inflater.findViewById<FloatingActionButton>(R.id.add_product)
        addFarmerButton.setOnClickListener{
            findNavController().navigate(R.id.action_listWorkersFragment_to_addFarmerFragment)
        }

        val activityAdapter = ActivityAdapter()
        val recyclerView = inflater.findViewById<RecyclerView>(R.id.workers_recycler_view)
        recyclerView.adapter = activityAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        /** Code to fetch from the API */
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = RetrofitInstance().createRetrofit()
                val apiResponse = apiService.getWorkers()

                val users = apiResponse.response

                withContext(Dispatchers.Main) {
                    inflater.findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                    activityAdapter.setUsers(users)

                }
            } catch (t: Throwable) {
                Toast.makeText(requireContext(), "No internet connection",Toast.LENGTH_LONG).show()
            }
        }

        /** Code to fetch from the phone ROOM database */
        CoroutineScope(Dispatchers.IO).launch {
            val dbBuilder = DBBuilder()
            val db = dbBuilder.createDB(requireContext())
            val dao = db.workersDao()
            val workers = dao.getAllWorkers()

            Log.d("workers", "$workers")
            list = workers

//            withContext(Dispatchers.Main) {
//                activityAdapter.setUsers(list)
//            }
        }

        return inflater
    }

}