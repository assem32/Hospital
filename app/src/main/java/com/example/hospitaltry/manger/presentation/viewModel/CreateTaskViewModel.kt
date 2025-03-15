package com.example.hospitaltry.manger.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.manger.data.model.CreateTaskModel
import com.example.hospitaltry.manger.data.model.CreateTaskResponse
import com.example.hospitaltry.manger.domain.useCase.CreateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject  constructor(val useCase: CreateTaskUseCase):ViewModel (){
    val responseTaskLiveData = MutableLiveData<CreateTaskResponse>()

    fun createTask(createTaskModel: CreateTaskModel){
        viewModelScope.launch {
            responseTaskLiveData.postValue(useCase.invoke(createTaskModel))
        }
    }

}