package com.example.hospitaltry.reciptionist.presintation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import com.example.hospitaltry.reciptionist.domain.useCase.GetCallsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class CallsViewModel @Inject constructor(val useCase: GetCallsUseCase):ViewModel() {

    val callLiveData=MutableLiveData<List<CallsEntity>>()


    fun getCalls(token :String){
        try {
            viewModelScope.launch {
                val response = useCase.invoke()
                callLiveData.postValue(response)
            }
        }
        catch (e:Exception){

        }

    }
}