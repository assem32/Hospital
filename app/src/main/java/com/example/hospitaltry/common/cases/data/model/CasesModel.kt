package com.example.hospitaltry.common.cases.data.model

data class CasesModel(
    val `data`: List<CaseData>,
    val message: String,
    val status: Int
)

data class CaseData(
    val created_at: String,
    val id: Int,
    val patient_name: String
)