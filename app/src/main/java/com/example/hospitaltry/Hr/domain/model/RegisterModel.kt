package com.example.hospitaltry.Hr.domain.model

data class RegisterModel(
    val email: String,
    val password: String,
    val first_name: String,
    val last_name: String,
    val gender: String,
    val specialist: String,
    val birthday: String,
    val status: String,
    val address: String,
    val mobile: String,
    val type: String,
)
