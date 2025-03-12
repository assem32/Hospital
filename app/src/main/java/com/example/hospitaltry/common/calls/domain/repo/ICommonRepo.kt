package com.example.hospitaltry.doctor.domain.repo

import com.example.hospitaltry.common.calls.domain.entity.CallsEntity

interface ICommonRepo {
    suspend fun getAllCalls():List<CallsEntity>
}