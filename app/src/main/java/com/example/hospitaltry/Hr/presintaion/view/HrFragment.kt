package com.example.hospitaltry.Hr.presintaion.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.databinding.FragmentHrHomeBinding
import com.example.hospitaltry.user


class HrFragment : Fragment() {

    var binding: FragmentHrHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHrHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.employeeContainer?.setOnClickListener {
            findNavController().navigate(
                HrFragmentDirections.actionSpecalistFragmentToAllDoctorsFragment(
                    user.accessToken
                )
            )
        }
        binding!!.taskContainer.setOnClickListener {
            findNavController().navigate(HrFragmentDirections.actionSpecalistFragmentToTasksFragment())
        }
        binding!!.containerReport.setOnClickListener {
            findNavController().navigate(HrFragmentDirections.actionSpecalistFragmentToReportsFragment())
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}