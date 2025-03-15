package com.example.hospitaltry.manger.domain.repo

import com.example.hospitaltry.manger.data.model.CreateTaskModel
import com.example.hospitaltry.manger.data.model.CreateTaskResponse

interface IMangerRepo {
    suspend fun createTask(createTaskModel: CreateTaskModel):CreateTaskResponse
}