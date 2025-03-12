package com.example.hospitaltry.common.calls.data.dataSource.remote

import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel

interface ICommonDataSource {
    suspend fun getDoctorCalls(): ReciptanistCallsModel

}