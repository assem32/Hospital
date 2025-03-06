package com.example.hospitaltry.reciptionist.domain.model

data class CallCreateEntitiy(
    val patient_name:String,
    val doctor_id:String,
    val age:String,
    val phone:String,
    val description:String
)
