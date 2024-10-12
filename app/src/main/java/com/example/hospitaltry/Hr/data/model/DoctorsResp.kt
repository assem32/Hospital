package com.example.hospitaltry.Hr.data.model


data class DoctorResp(
    val `data`: List<Data>,
    val message: String,
    val status: Int
)

data class Data(
    val avatar: String,
    val first_name: String,
    val id: Int,
    val type: String
)