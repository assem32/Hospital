package com.example.hospitaltry.doctor.domain.useCase

import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import javax.inject.Inject

class GetCallsDoctor @Inject constructor(val repo:ICommonRepo){
    suspend fun invoke():List<CallsEntity>{

        return repo.getAllCalls()
    }
}