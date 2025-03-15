package com.example.hospitaltry.common.cases.domain.repo

import com.example.hospitaltry.common.cases.data.model.CaseDetailsModel
import com.example.hospitaltry.common.cases.data.model.CasesModel

interface ICasesRepo {
    suspend fun getAllCases(): CasesModel

    suspend fun getCaseDetails(id: Int):CaseDetailsModel
}