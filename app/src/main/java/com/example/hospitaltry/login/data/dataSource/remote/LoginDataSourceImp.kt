package com.example.hospitaltry.login.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.Api.LoginRequest
import com.example.hospitaltry.login.data.model.UserModel
import retrofit2.Retrofit
import javax.inject.Inject

class LoginDataSourceImp @Inject constructor(val apiCalls: ApiCalls) :ILoginDataSource {
    override suspend fun login(email: String, password: String, token: String):UserModel {
        val response = apiCalls.login(LoginRequest(email,password,token))
        return response
    }
}