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
import com.noma.livestockcare.adapter.ProductsAdapter
import com.noma.livestockcare.model.DBBuilder
import com.noma.livestockcare.retrofit.ProductsRetrofitInstance
import com.noma.livestockcare.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        /** Inflate the layout for this fragment */
        val inflater = inflater.inflate(R.layout.fragment_list_products, container, false)
        inflater.findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE

        val backButton = inflater.findViewById<ImageView>(R.id.arrowback)

        backButton.setOnClickListener{
            findNavController().navigate(R.id.action_listProductsFragment_to_myHomeFragment)
        }

        /** Floating button that navigates to adding a single worker **/
//        val addFarmerButton = inflater.findViewById<FloatingActionButton>(R.id.add_product)
//        addFarmerButton.setOnClickListener{
//            findNavController().navigate(R.id.action_listWorkersFragment_to_addFarmerFragment)
//        }

        val productsAdapter = ProductsAdapter()
        val recyclerView = inflater.findViewById<RecyclerView>(R.id.workers_recycler_view)
        recyclerView.adapter = productsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        /** Code to fetch from the API */
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = ProductsRetrofitInstance().createRetrofit()
                val apiResponse = apiService.getProducts()

                val products = apiResponse.response

                withContext(Dispatchers.Main) {
                    inflater.findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                    productsAdapter.setProducts(products)

                }
            } catch (t: Throwable) {
                Toast.makeText(requireContext(), "No internet connection", Toast.LENGTH_LONG).show()
            }
        }

        return inflater


    }

}