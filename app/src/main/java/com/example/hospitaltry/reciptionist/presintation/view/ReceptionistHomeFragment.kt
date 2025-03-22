package com.example.hospitaltry.reciptionist.presintation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentReceptionistHomeBinding


class ReceptionistHomeFragment :Fragment() {
    lateinit var binding: FragmentReceptionistHomeBinding

    private val args: ReceptionistHomeFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceptionistHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentReceptionistHomeBinding.bind(view)

        val name = args.name
        val role = args.role
        val token = args.token

        binding.name.text=name
        binding.role.text=role

        binding.callContainer.setOnClickListener{
            findNavController().navigate(ReceptionistHomeFragmentDirections.actionReceptionistHomeFragmentToCallsFragment(token))
        }
        binding.containerReport.setOnClickListener{
            Log.d("token","ddddddddddddddddddddd")
            findNavController().navigate(ReceptionistHomeFragmentDirections.actionReceptionistHomeFragmentToReportsFragment())
        }
        binding.containerReport.setOnClickListener {
            findNavController().navigate(ReceptionistHomeFragmentDirections.actionReceptionistHomeFragmentToReportsFragment())
        }
        binding.containerTask.setOnClickListener {
            findNavController().navigate(ReceptionistHomeFragmentDirections.actionReceptionistHomeFragmentToTasksFragment())
        }

    }
}