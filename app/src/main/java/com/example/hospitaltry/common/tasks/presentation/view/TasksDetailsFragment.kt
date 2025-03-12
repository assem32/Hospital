package com.example.hospitaltry.common.tasks.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.hospitaltry.R
import com.example.hospitaltry.common.tasks.domain.repo.ITasksRepo
import com.example.hospitaltry.common.tasks.presentation.adapter.TodoAdapter
import com.example.hospitaltry.common.tasks.presentation.viewModel.TasksDetailsViewModel
import com.example.hospitaltry.databinding.FragmentTasksDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class TasksDetailsFragment :Fragment() {

    var binding :FragmentTasksDetailsBinding?=null

    private val viewModel : TasksDetailsViewModel by viewModels()

    lateinit var adapter: TodoAdapter

    @Inject
    lateinit var iRepo: ITasksRepo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTasksDetailsBinding.bind(view)

        adapter=TodoAdapter()

        viewModel.getTaskDetail()

        viewModel.taskDetailsLiveData.observe(viewLifecycleOwner){
            binding!!.txtTaskName.text=it.data.task_name
            binding!!.txtDetails.text=it.data.description
            binding!!.txtEmployeeName.text=it.data.user.first_name+it.data.user.last_name
            binding!!.txtEmployeeType.text=it.data.user.specialist
            binding!!.textDate.text=it.data.created_at
            binding!!.txtEmployeeDate.text=it.data.created_at
            if (it.data.note==null){
                binding!!.txtNote.text="No notes here"
            }
            adapter.list=it.data.to_do
            binding!!.recyclerTodo.adapter=adapter

        }


    }

}
