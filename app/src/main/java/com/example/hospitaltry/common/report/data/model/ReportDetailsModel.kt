package com.example.hospitaltry.common.report.data.model

data class ReportDetailsModel(
    val `data`: ReportDetailsData,
    val message: String,
    val status: Int
)

data class ReportDetailsData(
    val answer: String,
    val created_at: String,
    val description: String,
    val id: Int,
    val manger: Manger,
    val note: String,
    val report_name: String,
    val status: String,
    val user: User
)

data class Manger(
    val first_name: String,
    val id: String,
    val last_name: String,
    val specialist: String,
    val updated_at: String
)

data class User(
    val first_name: String,
    val id: Int,
    val last_name: String,
    val specialist: String
)