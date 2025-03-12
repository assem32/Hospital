package com.example.hospitaltry.reciptionist.data.repo

import com.example.hospitaltry.reciptionist.data.dataSource.mapper.toDomain
import com.example.hospitaltry.reciptionist.data.dataSource.remote.IReceptionistRemoteDataSource
import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import javax.inject.Inject

class ReciptinistRepo @Inject constructor(val iDoctorRemoteDataSource: IReceptionistRemoteDataSource): IReceptionistRepo {
//    override suspend fun getAllCalls(token:String) :List<CallsModleItem>{
//        val resp= iDoctorRemoteDataSource.getDoctorCalls(token)
//        return resp.toDomain()
//    }

    override suspend fun getCallDetail(id: Int,token :String): CallEntity {
        val resp= iDoctorRemoteDataSource.getCallDetails(id,token)
        return resp.toDomain()
    }

    override suspend fun createCall(callEntity: CallCreateEntitiy, token: String): CreateCallResp {
        val resp = iDoctorRemoteDataSource.createCall(callEntity,token)
        return resp
    }
}