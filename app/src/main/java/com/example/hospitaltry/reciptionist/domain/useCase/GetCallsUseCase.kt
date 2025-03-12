package com.example.hospitaltry.reciptionist.domain.useCase

import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import javax.inject.Inject

class GetCallsUseCase @Inject constructor(val repo:ICommonRepo){
    suspend fun invoke():List<CallsEntity>{

        return repo.getAllCalls()
    }
}