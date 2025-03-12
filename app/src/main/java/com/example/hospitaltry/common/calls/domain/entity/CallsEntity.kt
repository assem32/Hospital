package com.example.hospitaltry.common.calls.domain.entity

data class CallsEntity(
    val created_at: String,
    val id: Int,
    val patient_name: String,
    val status: String
)