package com.example.hospitaltry.reciptionist.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import javax.inject.Inject

class ReceptionistRemoteDataSourceImp @Inject constructor (val apiCalls: ApiCalls) :
    IReceptionistRemoteDataSource {
    override suspend fun getDoctorCalls(token :String): ReciptanistCallsModel{
        val token="Bearer $token"
        val response = apiCalls.getAllCalls(token)
        return response
    }

    override suspend fun getCallDetails(id: Int,token :String): CallDetailsModel {
        val token="Bearer $token"
        val resp= apiCalls.getCallDetails(id,token)
        return resp
    }

    override suspend fun createCall(callEntity: CallCreateEntitiy, token: String): CreateCallResp {
        val token="Bearer $token"
        val response=apiCalls.createCall(token,callEntity)
        return  response
    }
}