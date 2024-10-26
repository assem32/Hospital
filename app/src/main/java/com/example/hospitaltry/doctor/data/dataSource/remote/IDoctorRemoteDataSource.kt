package com.example.hospitaltry.doctor.data.dataSource.remote

import com.example.hospitaltry.doctor.data.model.AcceptAndDeclineModel
import com.example.hospitaltry.doctor.data.model.CallDetail
import com.example.hospitaltry.doctor.data.model.DoctorCallsModel

interface IDoctorRemoteDataSource {

    suspend fun getDoctorCalls():DoctorCallsModel

    suspend fun acceptDeclineCall(id:String,status:String):AcceptAndDeclineModel

    suspend fun getCallDetails(id: String):CallDetail
}