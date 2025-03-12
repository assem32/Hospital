package com.example.hospitaltry.common.calls.data.repo

import com.example.hospitaltry.common.calls.data.dataSource.remote.ICommonDataSource
import com.example.hospitaltry.common.calls.data.mapper.toDomain
import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import com.example.hospitaltry.reciptionist.data.dataSource.mapper.toDomain
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem
import javax.inject.Inject

class CommonRepoImp @Inject constructor(val iCommonDataSource: ICommonDataSource) :ICommonRepo {
    override suspend fun getAllCalls() :List<CallsEntity>{
        val resp= iCommonDataSource.getDoctorCalls()
        return resp.toDomain()
    }
}