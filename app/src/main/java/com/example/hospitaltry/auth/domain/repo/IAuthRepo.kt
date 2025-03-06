package com.example.hospitaltry.auth.domain.repo

import com.example.hospitaltry.auth.domain.model.User

interface IAuthRepo {
    suspend fun login(email:String, password:String, token:String):User

}