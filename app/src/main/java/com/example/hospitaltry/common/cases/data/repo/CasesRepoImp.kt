package com.example.hospitaltry.common.cases.data.repo

import com.example.hospitaltry.common.cases.data.dataSource.CasesDataSource
import com.example.hospitaltry.common.cases.data.model.CaseDetailsModel
import com.example.hospitaltry.common.cases.data.model.CasesModel
import com.example.hospitaltry.common.cases.domain.repo.ICasesRepo
import javax.inject.Inject

class CasesRepoImp @Inject constructor(val casesDataSource: CasesDataSource) : ICasesRepo {
    override suspend fun getAllCases(): CasesModel {
        val response=casesDataSource.getCases()
        return response
    }

    override suspend fun getCaseDetails(id: Int): CaseDetailsModel {
        val response=casesDataSource.getCaseDetails(id)
        return response
    }

}