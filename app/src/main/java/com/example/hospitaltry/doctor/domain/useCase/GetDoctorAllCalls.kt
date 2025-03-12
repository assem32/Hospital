package com.example.hospitaltry.doctor.domain.useCase

import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import javax.inject.Inject

class GetDoctorAllCalls @Inject constructor(val iCommonRepo: ICommonRepo){
    suspend fun invoke ():List<CallsEntity>{
        return iCommonRepo.getAllCalls()
    }
}