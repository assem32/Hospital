package com.example.hospitaltry.manger.data.repo

import com.example.hospitaltry.manger.data.model.CreateTaskModel
import com.example.hospitaltry.manger.data.model.CreateTaskResponse
import com.example.hospitaltry.manger.data.remote.MangerDataSource
import com.example.hospitaltry.manger.domain.repo.IMangerRepo
import javax.inject.Inject

class MangerRepo @Inject constructor(val mangerDataSource: MangerDataSource): IMangerRepo {
    override suspend fun createTask(createTaskModel: CreateTaskModel): CreateTaskResponse {
        val response = mangerDataSource.createTask(createTaskModel)
        return response
    }
}