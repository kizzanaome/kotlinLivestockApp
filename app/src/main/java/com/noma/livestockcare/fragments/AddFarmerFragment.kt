package com.noma.livestockcare.fragments

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.noma.livestockcare.MainActivity
import com.noma.livestockcare.R
import com.noma.livestockcare.databinding.FragmentAddFarmerBinding
import com.noma.livestockcare.model.DBBuilder
import com.noma.livestockcare.model.User
import com.noma.livestockcare.model.WorkersModel
import com.noma.livestockcare.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import kotlin.math.log


class AddFarmerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var _binding:FragmentAddFarmerBinding?= null
    val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val inflater = inflater.inflate(R.layout.fragment_add_farmer, container, false)
//        val first_name = inflater.findViewById<EditText>(R.id.first_name )
//        return inflater
//
//        val binding = FragmentAddFarmerBinding.inflate(layoutInflater)
//        val name = binding.firstName
//        return binding.root



//        _binding = FragmentAddFarmerBinding.inflate(layoutInflater)
//        val first_name = binding?.editFName
//        val last_name = binding?.editLName
//        val add_worker = binding?.addWorkerBtn
//        return binding?.root

        val inflater = inflater.inflate(R.layout.fragment_add_farmer, container, false)

        val addWorkerButton = inflater.findViewById<Button>(R.id.add_worker_btn)


        addWorkerButton.setOnClickListener{
            val first_name = inflater.findViewById<TextInputEditText>(R.id.edit_f_name).text.toString()
            val last_name = inflater.findViewById<TextInputEditText>(R.id.edit_l_name).text.toString()
            val phone_number = inflater.findViewById<TextInputEditText>(R.id.edit_phone).text.toString()
            val password = inflater.findViewById<TextInputEditText>(R.id.edit_password).text.toString()
            val role = inflater.findViewById<TextInputEditText>(R.id.edit_title).text.toString()
            val age = inflater.findViewById<TextInputEditText>(R.id.edit_age).text.toString()

             CoroutineScope(Dispatchers.IO).launch {


                try {
                    val dbBuilder = DBBuilder()
                    val db = dbBuilder.createDB(requireContext())
                    val dao = db.workersDao()

                    /** insert data to the Room Database **/
                    val worker = WorkersModel(
                        id = null,
                        firstName = first_name,
                        lastName = last_name,
                        role = role,
                        phoneNumber = phone_number,
                        image = "image.jpg",
                        password = password,
                        age = age,
                        gender = "female",
                    )
                    val insertQuery = dao.insertWorker(worker)
                    Log.d("insertQuery", "$insertQuery")


                    /** insert data to the API **/
                    val apiService = RetrofitInstance().createRetrofit()
                    val apiResponse = apiService.addWorker(
                        first_name,
                        last_name,
                        role,
                        phone_number,
                        password,
                        age,
                         "female",
                        "image.jpg",

                    )


                    /** Display Toast **/
                    withContext(Dispatchers.Main) {
                        /** Display Toast **/
                        val customToastLayout = layoutInflater.inflate(R.layout.customlayout,null)
                        val customToast = Toast(requireContext())
//                        customToast.setText(apiResponse?.message?.toString())
//                    customToast.setText(apiResponse?.message?.toString())
                    customToast.view = customToastLayout
                        customToast.setGravity(Gravity.BOTTOM,0,0)
                        customToast.duration = Toast.LENGTH_LONG
                        customToast.show()

                    }
                }catch (t:Throwable){
                    Log.d("Worker modal", "$t")
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Something went wrong!, Please try again later",Toast.LENGTH_LONG).show()

                    }

                }
            }

        }

        return inflater

    }
}