package com.example.hospitaltry.common.calls.data.mapper

import com.example.hospitaltry.common.calls.domain.entity.CallsEntity
import com.example.hospitaltry.reciptionist.data.model.CallData
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem

fun ReciptanistCallsModel.toDomain():List<CallsEntity>{
    return this.data.map {
        it.toDomain()
    }
}

fun CallData.toDomain(): CallsEntity {
    return CallsEntity(
        patient_name = this.patient_name,
        created_at = this.created_at,
        id = this.id,
        status = this.status
    )
}
