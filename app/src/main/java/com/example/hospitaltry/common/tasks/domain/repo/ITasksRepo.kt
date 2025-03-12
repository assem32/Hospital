package com.example.hospitaltry.common.tasks.domain.repo

import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel

interface ITasksRepo {
    suspend fun getTasks():AllTasksRespons

    suspend fun getTaskDetails(id: Int):TaskDetailsModel
}