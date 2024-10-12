package com.example.hospitaltry.Hr.domain.usecase

import com.example.hospitaltry.Hr.data.repo.GetAllDoctorsImp
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(val getAllDoctors:GetAllDoctorsImp){
    suspend fun invoke(){
        return
    }
}