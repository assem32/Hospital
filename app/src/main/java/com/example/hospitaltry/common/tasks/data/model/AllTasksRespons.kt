package com.example.hospitaltry.common.tasks.data.model

data class AllTasksRespons(
    val `data`: List<TasksData>,
    val message: String,
    val status: Int
)

data class TasksData(
    val created_at: String,
    val id: Int,
    val status: String,
    val task_name: String
)