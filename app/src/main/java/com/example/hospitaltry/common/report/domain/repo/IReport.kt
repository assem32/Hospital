package com.example.hospitaltry.common.report.domain.repo

import com.example.hospitaltry.common.report.data.model.AnswerModel
import com.example.hospitaltry.common.report.data.model.ReportAllModel
import com.example.hospitaltry.common.report.data.model.ReportDetailsModel

interface IReport {
    suspend fun getReport(date :String):ReportAllModel

    suspend fun getReportDetails(id: Int): ReportDetailsModel

    suspend fun mangerResponse(answer:String,id: Int): AnswerModel
}