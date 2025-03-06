package com.example.hospitaltry.reciptionist.domain.useCase

import com.example.hospitaltry.reciptionist.domain.model.CallsModleItem
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import javax.inject.Inject

class GetCallsUseCase @Inject constructor(val repo: IReceptionistRepo){
    suspend fun invoke(token :String):List<CallsModleItem>{

        return repo.getAllCalls(token)
    }
}