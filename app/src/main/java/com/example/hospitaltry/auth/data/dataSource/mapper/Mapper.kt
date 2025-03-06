package com.example.hospitaltry.auth.data.dataSource.mapper

import com.example.hospitaltry.auth.data.model.UserModel
import com.example.hospitaltry.auth.domain.model.User

fun UserModel.toDomain(): User {
    return User(
        accessToken = this.data.access_token,
        address = this.data.address,
        birthday = this.data.birthday,
        createdAt = this.data.created_at,
        email = this.data.email,
        firstName = this.data.first_name,
        gender = this.data.gender,
        id = this.data.id,
        lastName = this.data.last_name,
        mobile = this.data.mobile,
        specialist = this.data.specialist,
        status = this.data.status,
        tokenType = this.data.token_type,
        type = this.data.type
    )
}