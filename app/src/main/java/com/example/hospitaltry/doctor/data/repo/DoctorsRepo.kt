package com.example.hospitaltry.doctor.data.repo

import com.example.hospitaltry.doctor.data.dataSource.mapper.toDomain
import com.example.hospitaltry.doctor.data.dataSource.remote.IDoctorRemoteDataSource
import com.example.hospitaltry.doctor.data.model.AcceptAndDeclineModel
import com.example.hospitaltry.doctor.data.model.CallDetail
import com.example.hospitaltry.doctor.domain.model.CallsModleItem
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import javax.inject.Inject

class DoctorsRepo @Inject constructor(val iDoctorRemoteDataSource: IDoctorRemoteDataSource): IDoctorRepo {
    override suspend fun getDoctorCallsR() :List<CallsModleItem>{
        val resp= iDoctorRemoteDataSource.getDoctorCalls()
        return resp.toDomain()
    }

    override suspend fun acceptDeclineCall(id:String,status:String): AcceptAndDeclineModel {
        val resp=iDoctorRemoteDataSource.acceptDeclineCall(id,status)
        return resp
    }

    override suspend fun getCallDetail(id: String): CallDetail {
        val resp=iDoctorRemoteDataSource.getCallDetails(id)
        return resp
    }
}