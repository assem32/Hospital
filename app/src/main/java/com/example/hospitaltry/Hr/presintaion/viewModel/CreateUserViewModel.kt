package com.example.hospitaltry.Hr.presintaion.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import com.example.hospitaltry.Hr.domain.repo.IHrRepo
import com.example.hospitaltry.Hr.domain.usecase.CreateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CreateUserViewModel @Inject constructor(val uescase: CreateUserUseCase):ViewModel() {

    val gender = MutableLiveData(arrayOf("male","female"))

    val status = MutableLiveData(arrayOf("single","married"))

    val role = MutableLiveData(arrayOf("doctor","hr","receptionist"))

    val responseLiveData = MutableLiveData<RegisterNewUserModel>()

    fun registerFun(registerModel:RegisterModel,){
        viewModelScope.launch {
            try {
                val  response = uescase.invoke(registerModel)
                responseLiveData.postValue(response)
            }
            catch (e:Exception){
                Log.d("error",e.toString())
            }

            }
        }


}