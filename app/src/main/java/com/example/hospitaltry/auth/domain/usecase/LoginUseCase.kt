package com.example.hospitaltry.auth.domain.usecase

import com.example.hospitaltry.auth.domain.model.User
import com.example.hospitaltry.auth.domain.repo.IAuthRepo

class LoginUseCase (private val repo : IAuthRepo ) {
    suspend operator fun invoke(email: String, password:String,deviceToken:String): User{
        return repo.login(email,password,deviceToken)
    }
}