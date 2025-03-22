package com.example.hospitaltry.doctor.data.dataSource.remote

import com.example.hospitaltry.doctor.data.model.AcceptOrRejectModel

interface IDoctorDataSource {
    suspend fun acceptOrReject(callId:Int,status:String):AcceptOrRejectModel
}