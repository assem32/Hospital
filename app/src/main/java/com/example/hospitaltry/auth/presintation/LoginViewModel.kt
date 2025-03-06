package com.example.hospitaltry.auth.presintation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitaltry.auth.domain.model.User
import com.example.hospitaltry.auth.domain.repo.IAuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val iAuthRepo: IAuthRepo):ViewModel() {
    val userModel = MutableLiveData<User>()

    fun login(email:String,password:String){
        viewModelScope.launch {
            val response = iAuthRepo.login(email.trim(),password.trim(),"1233456")
            userModel.postValue(response)
        }
    }
}