package com.example.hospitaltry.reciptionist.data.model

data class ReciptanistCallsModel(
    val `data`: List<CallData>,
    val message: String,
    val status: Int
)

data class CallData(
    val created_at: String,
    val id: Int,
    val patient_name: String,
    val status: String
)