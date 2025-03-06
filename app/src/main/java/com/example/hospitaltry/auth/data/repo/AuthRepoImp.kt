package com.example.hospitaltry.auth.data.repo

import com.example.hospitaltry.auth.data.dataSource.mapper.toDomain
import com.example.hospitaltry.auth.data.dataSource.remote.IAuthDataSource
import com.example.hospitaltry.auth.domain.model.User
import com.example.hospitaltry.auth.domain.repo.IAuthRepo
import javax.inject.Inject

class AuthRepoImp @Inject constructor(val iAuthDataSource: IAuthDataSource ):IAuthRepo {
    override suspend fun login(email: String, password: String, token: String): User {
        val response=iAuthDataSource.login(email,password, token)
        return response.toDomain()
    }

}