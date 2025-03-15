package com.example.hospitaltry.manger.data.model

data class CreateTaskModel(
    val user_id:String,
    val task_name:String,
    val description:String,
    val todos:List<String>
)
