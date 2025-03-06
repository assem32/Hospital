package com.example.hospitaltry.auth.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.auth.data.model.LoginRequest
import com.example.hospitaltry.auth.data.model.UserModel
import javax.inject.Inject

class AuthDataSourceImp @Inject constructor(val apiCalls: ApiCalls) :IAuthDataSource {
    override suspend fun login(email: String, password: String, token: String):UserModel {
        val response = apiCalls.login(LoginRequest(email,password,token))
        return response
    }


}