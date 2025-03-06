package com.example.hospitaltry.Hr.data.repo

import com.example.hospitaltry.Hr.data.dataSource.remote.IGetDataSourceDoctors
import com.example.hospitaltry.Hr.data.dataSource.mapper.toDomain
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.domain.model.UserModelItem
import com.example.hospitaltry.Hr.domain.repo.IGetAllDoctorsRepo
import javax.inject.Inject

class GetAllDoctorsImp @Inject constructor(val iGetDoctors: IGetDataSourceDoctors):IGetAllDoctorsRepo {
    override suspend fun getDoctorR(token:String): List<UserModelItem> {
        val response = iGetDoctors.getDoctor(token)
        return response.toDomain()
    }

    override suspend fun getProfileR(id: String): ProfileData {
        val response = iGetDoctors.getProfile(id).toDomain()
        return  response
    }
}