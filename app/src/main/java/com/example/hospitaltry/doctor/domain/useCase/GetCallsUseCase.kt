package com.example.hospitaltry.doctor.domain.useCase

import com.example.hospitaltry.doctor.domain.model.CallsModleItem
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo

class GetCallsUseCase (val repo: IDoctorRepo){
    suspend fun invoke():List<CallsModleItem>{

        return repo.getDoctorCallsR()
    }
}