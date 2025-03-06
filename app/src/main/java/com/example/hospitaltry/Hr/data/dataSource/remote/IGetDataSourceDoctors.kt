package com.example.hospitaltry.Hr.data.dataSource.remote

import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.data.model.ProfileModel

interface IGetDataSourceDoctors {
    suspend fun getDoctor(token :String):DoctorResp

    suspend fun getProfile(id :String):ProfileModel
}