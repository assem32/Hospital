package com.example.hospitaltry.doctor.data.repo

import com.example.hospitaltry.doctor.data.dataSource.mapper.toDomain
import com.example.hospitaltry.doctor.data.dataSource.remote.IDoctorRemoteDataSource
import com.example.hospitaltry.doctor.domain.model.CallsModleItem
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import javax.inject.Inject

class DoctorsRepo @Inject constructor(val iDoctorRemoteDataSource: IDoctorRemoteDataSource): IDoctorRepo {
    override suspend fun getDoctorCallsR() :List<CallsModleItem>{
        val resp= iDoctorRemoteDataSource.getDoctorCalls()
        return resp.toDomain()
    }
}