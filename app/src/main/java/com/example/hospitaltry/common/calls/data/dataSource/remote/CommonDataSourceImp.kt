package com.example.hospitaltry.common.calls.data.dataSource.remote

import android.util.Log
import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.user
import javax.inject.Inject

class CommonDataSourceImp @Inject constructor(val apiCalls: ApiCalls): ICommonDataSource {
    override suspend fun getDoctorCalls(): ReciptanistCallsModel {
        val token="Bearer ${user.accessToken}"
        val response = apiCalls.getAllCalls(token)
        return response
    }

}