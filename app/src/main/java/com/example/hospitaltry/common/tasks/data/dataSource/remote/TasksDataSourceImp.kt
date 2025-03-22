package com.example.hospitaltry.common.tasks.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel
import com.example.hospitaltry.user
import javax.inject.Inject

class TasksDataSourceImp @Inject constructor(val apiCalls: ApiCalls):ITasksDataSource {
    override suspend fun getTasks() :AllTasksRespons{
        val token="Bearer ${user.accessToken}"
        val response = apiCalls.getTasks(token,"2025-03-09")
        return  response
    }

    override suspend fun getTasksDetails(id: Int): TaskDetailsModel {
        val token = "Bearer ${user.accessToken}"
        val response = apiCalls.getTaskDetails(token,id)
        return response
    }
}