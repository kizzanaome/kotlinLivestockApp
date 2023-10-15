package com.noma.livestockcare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.noma.livestockcare.R


class MyHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflater = inflater.inflate(R.layout.fragment_my_home, container, false)
        inflater.findViewById<CardView>(R.id.workers_card).setOnClickListener{
            findNavController().navigate(R.id.action_myHomeFragment_to_listWorkersFragment)
        }
        return inflater
    }

}