package com.example.hospitaltry.Hr.data.repo

import com.example.hospitaltry.Hr.data.dataSource.remote.IGetDataSourceDoctors
import com.example.hospitaltry.Hr.data.dataSource.mapper.toDomain
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import com.example.hospitaltry.Hr.domain.model.UserModelItem
import com.example.hospitaltry.Hr.domain.repo.IHrRepo
import javax.inject.Inject

class HrImp @Inject constructor(val iGetDoctors: IGetDataSourceDoctors):IHrRepo {
    override suspend fun getDoctor(token:String): List<UserModelItem> {
        val response = iGetDoctors.getDoctor(token)
        return response.toDomain()
    }

    override suspend fun getProfile(id: String): ProfileData {
        val response = iGetDoctors.getProfile(id).toDomain()
        return  response
    }

    override suspend fun createUser(registerModel: RegisterModel): RegisterNewUserModel {
        val response = iGetDoctors.createUser(registerModel)
        return response
    }
}