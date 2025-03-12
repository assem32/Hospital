package com.example.hospitaltry.Hr.domain.repo

import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import com.example.hospitaltry.Hr.domain.model.UserModelItem

interface IHrRepo {

    suspend fun getDoctor(token:String):List<UserModelItem>

    suspend fun getProfile(id :String):ProfileData

    suspend fun createUser(registerModel: RegisterModel):RegisterNewUserModel
}