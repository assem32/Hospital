package com.example.hospitaltry.login.domain.usecase

import com.example.hospitaltry.login.domain.model.User
import com.example.hospitaltry.login.domain.repo.ILoginRepo

class LoginUseCase (private val repo : ILoginRepo ) {
    suspend operator fun invoke(email: String, password:String,deviceToken:String): User{
        return repo.loginR(email,password,deviceToken)
    }
}