package com.example.hospitaltry.Hr.data.model

data class RegisterNewUserModel(
    val `data`: DataRegister,
    val message: String,
    val status: Int
)

data class DataRegister(
    val access_token: String,
    val address: String,
    val birthday: String,
    val created_at: String,
    val email: String,
    val first_name: String,
    val gender: String,
    val id: Int,
    val last_name: String,
    val mobile: String,
    val specialist: String,
    val status: String,
    val token_type: String,
    val type: String,
    val verified: Boolean
)