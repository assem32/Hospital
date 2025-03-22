package com.example.hospitaltry.doctor.data.repo

import com.example.hospitaltry.doctor.data.dataSource.remote.IDoctorDataSource
import com.example.hospitaltry.doctor.data.model.AcceptOrRejectModel
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import javax.inject.Inject

class DoctorRepoImp @Inject constructor(val iDoctorDataSource: IDoctorDataSource) :IDoctorRepo {
    override suspend fun acceptOrReject(callId: Int,status:String): AcceptOrRejectModel {
        val response = iDoctorDataSource.acceptOrReject(callId,status)
        return response
    }
}