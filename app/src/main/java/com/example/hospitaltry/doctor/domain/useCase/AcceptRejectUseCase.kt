package com.example.hospitaltry.doctor.domain.useCase

import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.doctor.data.model.AcceptOrRejectModel
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import javax.inject.Inject

class AcceptRejectUseCase @Inject constructor(val iDoctorRepo : IDoctorRepo) {
    suspend fun invoke (callId:Int,status:String):AcceptOrRejectModel{
        return iDoctorRepo.acceptOrReject(callId,status)
    }
}