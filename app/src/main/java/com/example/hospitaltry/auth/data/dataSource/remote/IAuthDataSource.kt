package com.example.hospitaltry.auth.data.dataSource.remote

import com.example.hospitaltry.auth.data.model.UserModel

interface IAuthDataSource {
    suspend fun login(email:String,password:String, token:String):UserModel

}