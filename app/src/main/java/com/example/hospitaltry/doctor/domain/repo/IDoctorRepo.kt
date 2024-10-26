package com.example.hospitaltry.doctor.domain.repo

import com.example.hospitaltry.doctor.data.model.AcceptAndDeclineModel
import com.example.hospitaltry.doctor.data.model.CallDetail
import com.example.hospitaltry.doctor.domain.model.CallsModleItem

interface IDoctorRepo {
    suspend fun getDoctorCallsR():List<CallsModleItem>
    suspend fun acceptDeclineCall(id:String,status:String):AcceptAndDeclineModel
    suspend fun getCallDetail(id: String):CallDetail
}