package com.example.hospitaltry.common.cases.data.model

data class CaseDetailsModel(
    val `data`: CaseDetailsData,
    val message: String,
    val status: Int
)

data class CaseDetailsData(
    val age: String,
    val analysis_id: String,
    val blood_pressure: String,
    val case_status: String,
    val created_at: String,
    val description: String,
    val doc_id: Int,
    val doctor_id: String,
    val fluid_balance: String,
    val heart_rate: String,
    val id: Int,
    val image: String,
    val measurement_note: String,
    val medical_record_note: String,
    val nurse_id: String,
    val patient_name: String,
    val phone: String,
    val respiratory_rate: String,
    val status: String,
    val sugar_analysis: String,
    val tempreture: String
)