package com.example.hospitaltry.Hr.presintaion.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.databinding.FragmentSpecailistHomeBinding

class SpecalistFragment :Fragment() {

    var binding: FragmentSpecailistHomeBinding? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSpecailistHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.employeeLayout?.setOnClickListener {
            findNavController().navigate(SpecalistFragmentDirections.actionSpecalistFragmentToAllDoctorsFragment())
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Avoid memory leaks by clearing the binding
    }
}