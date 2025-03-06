package com.example.hospitaltry.reciptionist.domain.repo

import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem

interface IReceptionistRepo {
    suspend fun getAllCalls(token :String):List<CallsModleItem>

    suspend fun getCallDetail(id :Int,token :String):CallEntity

    suspend fun createCall(callEntity: CallCreateEntitiy,token :String):CreateCallResp


}