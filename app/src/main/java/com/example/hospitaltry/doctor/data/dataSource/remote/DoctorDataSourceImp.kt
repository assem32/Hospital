package com.example.hospitaltry.doctor.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.doctor.data.model.AcceptOrRejectModel
import com.example.hospitaltry.user
import javax.inject.Inject

class DoctorDataSourceImp @Inject constructor(val apiCalls: ApiCalls):IDoctorDataSource {
    override suspend fun acceptOrReject(callId: Int,status:String): AcceptOrRejectModel {
        val token="Bearer ${user.accessToken}"
        val response = apiCalls.acceptOrReject(token,callId,status)
        return response
    }
}