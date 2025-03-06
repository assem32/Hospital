package com.example.hospitaltry.reciptionist.presintation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.useCase.GetCallDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CallDetailsViewModel @Inject constructor(val useCase: GetCallDetailsUseCase) :ViewModel() {
    val callDetailsLiveData=MutableLiveData<CallEntity>()

    fun getDetails(id:Int, token:String){
        try {
            viewModelScope.launch {
                callDetailsLiveData.postValue(useCase.invoke(id, token))
            }
        }
        catch (e:Exception){

        }
    }
}