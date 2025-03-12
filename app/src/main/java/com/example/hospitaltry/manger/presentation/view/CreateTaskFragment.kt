package com.example.hospitaltry.manger.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentTasksCreateBinding

class CreateTaskFragment :Fragment() {

    var binding : FragmentTasksCreateBinding?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentTasksCreateBinding.bind(view)
    }

}

