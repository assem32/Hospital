package com.example.hospitaltry.Hr.data.dataSource.remote

import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.data.model.ProfileModel
import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel

interface IGetDataSourceDoctors {
    suspend fun getDoctor(token :String):DoctorResp

    suspend fun getProfile(id :String):ProfileModel

    suspend fun createUser(registerModel: RegisterModel):RegisterNewUserModel
}