package com.example.hospitaltry.login.data.repo

import com.example.hospitaltry.login.data.dataSource.mapper.toDomain
import com.example.hospitaltry.login.data.dataSource.remote.ILoginDataSource
import com.example.hospitaltry.login.domain.model.User
import com.example.hospitaltry.login.domain.repo.ILoginRepo
import javax.inject.Inject

class LoginRepo @Inject constructor(val iLoginDataSource: ILoginDataSource ):ILoginRepo {
    override suspend fun loginR(email: String, password: String, token: String): User {
        val response=iLoginDataSource.login(email,password, token)
        return response.toDomain()
    }
}