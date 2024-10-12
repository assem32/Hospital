package com.example.hospitaltry.doctor.presintation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentDoctorHomeBinding
import com.example.hospitaltry.databinding.FragmentLoginBinding
import com.example.hospitaltry.databinding.FragmentSpecailistHomeBinding
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


class DoctorHomeFragment :Fragment() {
    var binding: FragmentDoctorHomeBinding? =null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentDoctorHomeBinding.bind(view)
        binding!!.callsContainer.setOnClickListener{
            findNavController().navigate(DoctorHomeFragmentDirections.actionDoctorHomeFragmentToCallsFragment())

        }

    }
}