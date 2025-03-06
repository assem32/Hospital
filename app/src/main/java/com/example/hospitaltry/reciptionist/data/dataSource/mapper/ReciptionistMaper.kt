package com.example.hospitaltry.reciptionist.data.dataSource.mapper

import com.example.hospitaltry.reciptionist.data.model.CallData
import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem

fun ReciptanistCallsModel.toDomain():List<CallsModleItem>{
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


fun CallDetailsModel.toDomain():CallEntity{
    return CallEntity(
        name = this.data.patient_name,
        age = this.data.age,
        phone = this.data.phone,
        date = this.data.created_at,
        status=this.data.status,
        description = this.data.description
    )
}
