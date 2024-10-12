package com.example.hospitaltry.doctor.data.dataSource.mapper

import com.example.hospitaltry.doctor.data.model.CallData
import com.example.hospitaltry.doctor.data.model.DoctorCallsModel
import com.example.hospitaltry.doctor.domain.model.CallsModleItem

fun DoctorCallsModel.toDomain():List<CallsModleItem>{
    return this.data.map {
        it.toDomain()
    }
}

fun CallData.toDomain():CallsModleItem{
    return CallsModleItem(
        patient_name = this.patient_name,
        created_at = this.created_at,
        id = this.id,
        status = this.status
    )
}