package com.example.hospitaltry.common.tasks.data.repo

import com.example.hospitaltry.common.tasks.data.dataSource.remote.ITasksDataSource
import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel
import com.example.hospitaltry.common.tasks.domain.repo.ITasksRepo
import javax.inject.Inject

class TasksRepoImp @Inject constructor(val iTasksDataSource: ITasksDataSource): ITasksRepo {
    override suspend fun getTasks(): AllTasksRespons {
        val response= iTasksDataSource.getTasks()
        return response
    }

    override suspend fun getTaskDetails(id: Int): TaskDetailsModel {
        val response= iTasksDataSource.getTasksDetails(id)
        return response
    }
}