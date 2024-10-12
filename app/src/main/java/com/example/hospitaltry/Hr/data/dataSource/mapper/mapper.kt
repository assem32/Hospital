package com.example.hospitaltry.Hr.data.dataSource.mapper

import com.example.hospitaltry.Hr.data.model.Data
import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.data.model.ProfileModel
import com.example.hospitaltry.Hr.domain.model.UserModelItem


fun DoctorResp.toDomain():List<UserModelItem>{
    return this.data.map {
        it.toDomain()
    }
}

fun Data.toDomain(): UserModelItem {
    return UserModelItem(
        avatar = this.avatar,
        firstName = this.first_name,
        id = this.id,
        type = this.type
    )
}

fun ProfileModel.toDomain():ProfileData{
    return ProfileData(
        access_token = this.data.access_token,
        birthday=this.data.birthday,
        address = this.data.address,
        email=this.data.email,
        first_name = this.data.first_name,
        last_name=this.data.last_name,
        mobile = this.data.mobile,
        gender=this.data.gender,
        specialist = this.data.specialist,
        status=this.data.status,
        type = this.data.type,
        verified = this.data.verified,
        created_at = this.data.created_at,
        id = this.data.id,
        token_type = this.data.token_type
    )

}