package com.example.hospitaltry.doctor.domain.repo

import com.example.hospitaltry.doctor.data.model.AcceptOrRejectModel

interface IDoctorRepo {
    suspend fun acceptOrReject(callId:Int,status:String):AcceptOrRejectModel
}