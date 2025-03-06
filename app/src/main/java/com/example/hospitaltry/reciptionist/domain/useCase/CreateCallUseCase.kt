package com.example.hospitaltry.reciptionist.domain.useCase

import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import javax.inject.Inject

class CreateCallUseCase @Inject constructor(val iReceptionistRepo: IReceptionistRepo) {
    suspend fun invoke (callEntity: CallCreateEntitiy,token:String): CreateCallResp {
        return iReceptionistRepo.createCall(callEntity,token)
    }
}