package com.example.hospitaltry.login.data.dataSource.remote

import com.example.hospitaltry.login.data.model.UserModel

interface ILoginDataSource {
    suspend fun login(email:String,password:String, token:String):UserModel
}