package com.example.hospitaltry.Api


data class LoginRequest(
    val email: String,
    val password: String,
    val token: String
)
