package com.example.hospitaltry.common.tasks.data.dataSource.remote

import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel

interface ITasksDataSource {
    suspend fun getTasks(): AllTasksRespons

    suspend fun getTasksDetails(id:Int):TaskDetailsModel

}