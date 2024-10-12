package com.example.hospitaltry.doctor.data.dataSource.remote

import com.example.hospitaltry.doctor.data.model.DoctorCallsModel

interface IDoctorRemoteDataSource {

    suspend fun getDoctorCalls():DoctorCallsModel
}