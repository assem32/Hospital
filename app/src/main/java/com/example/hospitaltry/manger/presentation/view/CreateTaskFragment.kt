package com.example.hospitaltry.manger.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hospitaltry.R
import com.example.hospitaltry.databinding.FragmentTasksCreateBinding
import com.example.hospitaltry.manger.data.model.CreateTaskModel
import com.example.hospitaltry.manger.domain.useCase.CreateTaskUseCase
import com.example.hospitaltry.manger.presentation.adapter.TaskDelAdapter
import com.example.hospitaltry.manger.presentation.viewModel.CreateTaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CreateTaskFragment : Fragment(), BottomSheetTask.OnBottomSheetSubmitListener {

    var binding: FragmentTasksCreateBinding? = null

    @Inject
    lateinit var useCase: CreateTaskUseCase

    private val viewModel: CreateTaskViewModel by viewModels()

    var list: List<String> = listOf()

    lateinit var adapter: TaskDelAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTasksCreateBinding.bind(view)
        adapter = TaskDelAdapter()
        adapter.list = list
        binding!!.recyclerTodoDel.adapter = adapter



        binding!!.btnSend.setOnClickListener {
            var model = CreateTaskModel(
                user_id = "138",
                task_name = binding!!.edtTaskName.text.toString(),
                todos = list,
                description = binding!!.edtDescription.text.toString(),

                )
            viewModel.createTask(model)
        }
        binding!!.btnAddTask.setOnClickListener {
            val bottomSheet = BottomSheetTask()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }
        viewModel.responseTaskLiveData.observe(viewLifecycleOwner) {
            if (it.status == 1) {
                binding!!.edtTaskName.text.clear()
                list = listOf()
                adapter.list = list
                binding!!.recyclerTodoDel.adapter = adapter
                binding!!.edtDescription.text.clear()
                Toast.makeText(view.context,"Created Success",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSubmit(input: String) {
        list += input
        adapter.list = list
        binding!!.recyclerTodoDel.adapter = adapter
    }


}

