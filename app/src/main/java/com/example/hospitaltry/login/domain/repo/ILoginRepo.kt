package com.example.hospitaltry.login.domain.repo

import com.example.hospitaltry.login.domain.model.User

interface ILoginRepo {
    suspend fun loginR(email:String,password:String,token:String,):User
}