package com.example.hospitaltry.doctor.presintation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentCallsBinding
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import com.example.hospitaltry.doctor.presintation.recyclerView.CallsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CallsFragment :Fragment() {

    private lateinit var adapter: CallsAdapter

    var binding: FragmentCallsBinding? =null

    @Inject
    lateinit var iDoctorRepo: IDoctorRepo
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCallsBinding.bind(view)

        adapter= CallsAdapter (
            {
                findNavController().navigate(CallsFragmentDirections.actionCallsFragmentToCallDetailsFragement())
            },
            {
                callId->
                lifecycleScope.launch {
                    try {
                        // Use the passed call ID for accept/decline actions
                        iDoctorRepo.acceptDeclineCall(callId.toString(),"accept")
                        adapter.callList= emptyList()
                        val resp =iDoctorRepo.getDoctorCallsR()
                        adapter.callList=resp
                        binding?.recyclerCalls?.layoutManager= LinearLayoutManager(requireContext())
                        binding!!.recyclerCalls.adapter=adapter
                    // Pass the ID to your repository function
                    } catch (e: Exception) {
                        Log.e("gg", "Error accepting/declining call: $e")
                    }
                }
            },
            {
                    callId->
                lifecycleScope.launch {
                    try {
                        // Use the passed call ID for accept/decline actions
                        iDoctorRepo.acceptDeclineCall(callId.toString(),"reject")
                        adapter.callList= emptyList()
                        val resp =iDoctorRepo.getDoctorCallsR()
                        adapter.callList=resp
                        binding?.recyclerCalls?.layoutManager= LinearLayoutManager(requireContext())
                        binding!!.recyclerCalls.adapter=adapter

                    // Pass the ID to your repository function
                    } catch (e: Exception) {
                        Log.e("gg", "Error accepting/declining call: $e")
                    }
                }
            }

            )

//        adapter.callList= emptyList()

        lifecycleScope.launch {
            val resp =iDoctorRepo.getDoctorCallsR()
//            Log.d("fuu",resp.get(0).patient_name)
            adapter.callList=resp


            binding?.recyclerCalls?.layoutManager= LinearLayoutManager(requireContext())
            binding!!.recyclerCalls.adapter=adapter
        }

    }
}