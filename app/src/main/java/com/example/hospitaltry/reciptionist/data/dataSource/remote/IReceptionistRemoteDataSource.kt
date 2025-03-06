package com.example.hospitaltry.reciptionist.data.dataSource.remote

import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity

interface IReceptionistRemoteDataSource {

    suspend fun getDoctorCalls(token :String):ReciptanistCallsModel

    suspend fun getCallDetails(id:Int,token :String):CallDetailsModel

    suspend fun createCall(callEntity:CallCreateEntitiy,token: String): CreateCallResp
}