package com.example.hospitaltry.manger.domain.useCase

import com.example.hospitaltry.manger.data.model.CreateTaskModel
import com.example.hospitaltry.manger.data.model.CreateTaskResponse
import com.example.hospitaltry.manger.domain.repo.IMangerRepo
import javax.inject.Inject

class CreateTaskUseCase  @Inject constructor(val iMangerRepo: IMangerRepo){
    suspend fun invoke(createTaskModel: CreateTaskModel):CreateTaskResponse{
        val response=iMangerRepo.createTask(createTaskModel)
        return response
    }
}