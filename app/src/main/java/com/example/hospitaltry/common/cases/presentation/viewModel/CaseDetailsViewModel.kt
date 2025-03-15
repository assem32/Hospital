package com.example.hospitaltry.common.cases.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.common.cases.data.model.CaseDetailsModel
import com.example.hospitaltry.common.cases.domain.repo.ICasesRepo
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel
import com.example.hospitaltry.reciptionist.domain.useCase.GetCallDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CaseDetailsViewModel @Inject constructor(val useCase: ICasesRepo):ViewModel() {
    val taskDetailsLiveData = MutableLiveData<CaseDetailsModel>()
    fun getDetails(id: Int){
        viewModelScope.launch {
            taskDetailsLiveData.postValue(useCase.getCaseDetails(id))
        }

    }

}