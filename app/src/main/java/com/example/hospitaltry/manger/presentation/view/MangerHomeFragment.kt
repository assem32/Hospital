package com.example.hospitaltry.manger.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentMangerHomeBinding

class MangerHomeFragment :Fragment(){

    var binding : FragmentMangerHomeBinding ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manger_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding= FragmentMangerHomeBinding.bind(view)
        binding!!.taskContainer.setOnClickListener{
            findNavController().navigate(MangerHomeFragmentDirections.actionMangerHomeFragmentToTasksFragment())
        }
    }
}