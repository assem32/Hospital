package com.example.hospitaltry.common.report.data.dataSource

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.report.data.model.AnswerModel
import com.example.hospitaltry.common.report.data.model.ReportAllModel
import com.example.hospitaltry.common.report.data.model.ReportDetailsModel
import com.example.hospitaltry.user
import javax.inject.Inject

class ReportsDataSource @Inject constructor(val apiCalls: ApiCalls) {
    suspend fun getReports( date: String):ReportAllModel{
        val token = "Bearer ${user.accessToken}"
        return apiCalls.getReports(token,date)
    }
    suspend fun getReportDetail(id: Int):ReportDetailsModel{
        val token = "Bearer ${user.accessToken}"
        return apiCalls.getReportDetails(token,id)
    }
    suspend fun mangerAnswer(id: Int,answer: String):AnswerModel{
        val token = "Bearer ${user.accessToken}"
        return apiCalls.putReportAnswer(token,id,answer)
    }
}