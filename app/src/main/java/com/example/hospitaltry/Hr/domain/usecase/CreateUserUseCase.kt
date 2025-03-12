package com.example.hospitaltry.Hr.domain.usecase

import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import com.example.hospitaltry.Hr.domain.repo.IHrRepo
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(val iHrRepo: IHrRepo) {
    suspend fun invoke(registerModel: RegisterModel,):RegisterNewUserModel{
        return iHrRepo.createUser(registerModel)
    }
}