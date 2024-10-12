package com.example.hospitaltry.Hr.domain.repo

import com.example.hospitaltry.Hr.data.model.Data
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.domain.model.UserModelItem

interface IGetAllDoctorsRepo {

    suspend fun getDoctorR():List<UserModelItem>

    suspend fun getProfileR(id :String):ProfileData
}