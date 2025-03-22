package com.example.hospitaltry.common.cases.data.dataSource

import android.util.Log
import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.cases.data.model.CaseDetailsModel
import com.example.hospitaltry.common.cases.data.model.CasesModel
import com.example.hospitaltry.user
import javax.inject.Inject

class CasesDataSource @Inject constructor(val apiCalls: ApiCalls) {
    suspend fun getCases():CasesModel{
        val token = "Bearer ${user.accessToken}"
        val response = apiCalls.getCases(token)
        Log.d("wel",""+response)
        return response
    }

    suspend fun getCaseDetails(id: Int):CaseDetailsModel{
        val token = "Bearer ${user.accessToken}"
        val response = apiCalls.getCaseDetails(token,id)
        return response
    }
}