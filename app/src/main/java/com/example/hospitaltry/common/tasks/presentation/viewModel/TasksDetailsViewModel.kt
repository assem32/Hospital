package com.example.hospitaltry.common.tasks.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel
import com.example.hospitaltry.common.tasks.domain.repo.ITasksRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksDetailsViewModel @Inject constructor(val useCase: ITasksRepo) :ViewModel() {
    val taskDetailsLiveData = MutableLiveData<TaskDetailsModel>()

    fun getTaskDetail(){
        viewModelScope.launch {
            val response = useCase.getTaskDetails(74)
            taskDetailsLiveData.postValue(response)
        }
    }

}