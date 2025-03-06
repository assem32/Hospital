package com.example.hospitaltry.reciptionist.domain.useCase

import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import javax.inject.Inject

class GetCallDetailsUseCase @Inject constructor(val iReceptionistRepo: IReceptionistRepo) {
    suspend fun invoke (id:Int,token:String):CallEntity{
        return iReceptionistRepo.getCallDetail(id,token)
    }
}