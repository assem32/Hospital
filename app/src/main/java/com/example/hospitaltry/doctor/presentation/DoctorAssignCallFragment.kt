package com.example.hospitaltry.doctor.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.hospitaltry.databinding.FragmentDoctorAssignCallsBinding
import com.example.hospitaltry.databinding.FragmentDoctorHomeBinding
import com.example.hospitaltry.doctor.domain.useCase.GetDoctorAllCalls
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DoctorAssignCallFragment :Fragment() {
    var binding: FragmentDoctorAssignCallsBinding? = null

    @Inject
    lateinit var getDoctorAllCalls: GetDoctorAllCalls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDoctorAssignCallsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorAssignCallsBinding.bind(view)
        lifecycleScope.launch {
            getDoctorAllCalls.invoke()
            Log.d("doctor",""+getDoctorAllCalls.invoke().get(0))
        }
    }
}