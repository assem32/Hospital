package com.example.hospitaltry.common.report.data.repo

import com.example.hospitaltry.common.report.data.dataSource.ReportsDataSource
import com.example.hospitaltry.common.report.data.model.AnswerModel
import com.example.hospitaltry.common.report.data.model.ReportAllModel
import com.example.hospitaltry.common.report.data.model.ReportDetailsData
import com.example.hospitaltry.common.report.data.model.ReportDetailsModel
import com.example.hospitaltry.common.report.domain.repo.IReport
import javax.inject.Inject

class RepoImp @Inject constructor(val reportsDataSource: ReportsDataSource): IReport {
    override suspend fun getReport(date: String): ReportAllModel {
        return reportsDataSource.getReports(date)
    }

    override suspend fun getReportDetails(id: Int):ReportDetailsModel {
        return reportsDataSource.getReportDetail(id)
    }

    override suspend fun mangerResponse(answer: String, id: Int): AnswerModel {
        return reportsDataSource.mangerAnswer(id, answer)
    }
}