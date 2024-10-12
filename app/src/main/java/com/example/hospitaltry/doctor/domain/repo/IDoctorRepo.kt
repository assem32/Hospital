package com.example.hospitaltry.doctor.domain.repo

import com.example.hospitaltry.doctor.domain.model.CallsModleItem

interface IDoctorRepo {
    suspend fun getDoctorCallsR():List<CallsModleItem>
}