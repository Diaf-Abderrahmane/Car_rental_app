package com.example.rental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.*
import sendGetRequest



class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = MarqueModel()
        val view = requireActivity().findViewById<RecyclerView>(R.id.rvBrands)
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        view.layoutManager = layoutManager
        view.adapter = MarqueAdapter(requireContext(), vm.data)

        val vmCars = CarModel()
        val viewCars = requireActivity().findViewById<RecyclerView>(R.id.rvCars)
        val layoutManagerCars = GridLayoutManager(requireContext(), 2)
        viewCars.layoutManager = layoutManagerCars
        viewCars.adapter = CarAdapter(requireContext(), vmCars.data)
<<<<<<< HEAD

        val brand = requireActivity().findViewById<TextView>(R.id.brand)
=======
        val hh = requireActivity().findViewById<TextView>(R.id.hh)
            //val response = sendGetRequest("http://localhost:8000/simple/")
>>>>>>> parent of e2d6b52 (last)

        GlobalScope.launch(Dispatchers.IO) {
            val response = sendGetRequest("http://127.0.0.1:9000/simple/")
            withContext(Dispatchers.Main) {
                // Update the UI with the result
                hh.text = response
            }
        }

<<<<<<< HEAD
//        brand.setOnClickListener {
//
//            CoroutineScope(Dispatchers.IO).launch {
//                val response = RetrofitService.endpoint.simple()
//                withContext(Dispatchers.Main){
//
//                    if(response.isSuccessful) {
//
//                        brand.text = response.body()
//                        Toast.makeText(requireActivity(),"ay mchat a l7aj", Toast.LENGTH_LONG).show()
//
//
//                    } else {
//
//                        Toast.makeText(requireActivity(),response.toString(), Toast.LENGTH_LONG).show()
//
//                    }
//                } // retourner vers le main thread ( programmation synchrone )
//            }
//
//
//        }

        val hh = requireActivity().findViewById<TextView>(R.id.hh)
        val response = sendGetRequest("127.0.0.1:8000:simple/")
        hh.text = response



=======
>>>>>>> parent of e2d6b52 (last)



    }



}