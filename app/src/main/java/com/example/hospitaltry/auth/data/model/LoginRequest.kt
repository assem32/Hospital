package com.example.hospitaltry.auth.data.model


data class LoginRequest(
    val email: String,
    val password: String,
    val token: String
)
