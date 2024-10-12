package com.example.hospitaltry.doctor.data.model

data class DoctorCallsModel(
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