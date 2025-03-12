package com.example.hospitaltry.doctor.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.databinding.FragmentDoctorHomeBinding
import com.example.hospitaltry.databinding.FragmentHrHomeBinding
import dagger.hilt.android.AndroidEntryPoint



class DoctorHomeFragment :Fragment(){
    var binding: FragmentDoctorHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDoctorHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorHomeBinding.bind(view)

        binding!!.containerAddCall.setOnClickListener{
            findNavController().navigate(DoctorHomeFragmentDirections.actionDoctorHomeFragmentToDoctorAssignCallFragment())
        }
    }
}