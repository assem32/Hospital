package com.example.hospitaltry.reciptionist.presintation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.useCase.CreateCallUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallCreateViewModel @Inject constructor(val useCase: CreateCallUseCase):ViewModel(){
    val createResponseLiveData = MutableLiveData<CreateCallResp>()

    fun createCall(callEntity: CallCreateEntitiy,token:String){
        viewModelScope.launch {
            val reponse =useCase.invoke(callEntity,token)
            createResponseLiveData.postValue(reponse)
        }
    }
}