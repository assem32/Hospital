package com.example.hospitaltry.Hr.domain.usecase

import com.example.hospitaltry.Hr.data.repo.HrImp
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(val getAllDoctors:HrImp){
    suspend fun invoke(){
        return
    }
}