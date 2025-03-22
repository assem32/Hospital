package com.example.hospitaltry.doctor.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.doctor.domain.useCase.AcceptRejectUseCase
import com.example.hospitaltry.doctor.domain.useCase.GetCallsDoctor
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import com.example.hospitaltry.reciptionist.domain.useCase.GetCallsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class CallsDoctorViewModel @Inject constructor(val useCase: GetCallsDoctor,val useCase2: AcceptRejectUseCase):ViewModel() {

    val callLiveData=MutableLiveData<List<CallsEntity>>()
    val acceptRejectLiveData=MutableLiveData<String>()

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
    fun AcceptOrRejectCalls(id: Int,status: String){
        try {
            viewModelScope.launch {
                val response = useCase2.invoke(id,status)
                acceptRejectLiveData.postValue(response.message)
            }
        }
        catch (e:Exception){

        }

    }
}