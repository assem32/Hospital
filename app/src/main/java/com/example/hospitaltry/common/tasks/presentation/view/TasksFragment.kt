package com.example.hospitaltry.common.tasks.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospitaltry.R
import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TasksData
import com.example.hospitaltry.common.tasks.domain.repo.ITasksRepo
import com.example.hospitaltry.common.tasks.presentation.adapter.TasksAdapter
import com.example.hospitaltry.databinding.FragmentTasksBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TasksFragment :Fragment(){

    var binding : FragmentTasksBinding?=null

    lateinit var adapter : TasksAdapter

    @Inject
    lateinit var iRepo:ITasksRepo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentTasksBinding.bind(view)

        adapter= TasksAdapter()



        val task = TasksData(
            id = 73,
            task_name = "ttestset",
            created_at = "2025-03-09",
            status = "pending"
        )


        val response=AllTasksRespons(
            status = 1,
            message = "done",
            data = listOf(task,task,task)
        )

        lifecycleScope.launch {
            adapter.list= iRepo.getTasks().data
            binding?.recyclerTasks?.layoutManager= LinearLayoutManager(requireContext())
            binding?.recyclerTasks?.adapter=adapter
        }
//        binding?.recyclerTasks?.layoutManager= LinearLayoutManager(requireContext())
//        binding?.recyclerTasks?.adapter=adapter
    }
}