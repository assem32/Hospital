package com.example.hospitaltry.common.report.data.model

data class ReportAllModel(
    val `data`: List<ReportData>,
    val message: String,
    val status: Int
)

data class ReportData(
    val created_at: String,
    val id: Int,
    val report_name: String,
    val status: String
)