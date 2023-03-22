package com.example.rental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hh = requireActivity().findViewById<RecyclerView>(R.id.haha)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false)
    }
}