package com.example.hospitaltry.Hr.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.Hr.data.dataSource.mapper.toDomain
import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileData
import com.example.hospitaltry.Hr.data.model.ProfileModel
import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import javax.inject.Inject

class GetDoctorsDataSourceImp @Inject constructor(val apiCalls: ApiCalls): IGetDataSourceDoctors {
    override suspend fun getDoctor(token :String) :DoctorResp {

        val token="Bearer $token"
        val response = apiCalls.getDoctors(token)
        return response
    }

    override suspend fun getProfile(id : String): ProfileModel {
        val token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiZjlkNGY2NjA3ZTc4NDBjMzc4MjliZWZlNzdjYzM2NTdlZTQ2MzAwZGZiYjQxYTk3MjM1MzhhZDk3NzJiMTc3YzQ5MjA2ZGE3YThjOTlhZmYiLCJpYXQiOjE3MjYzMzA5NjUuODIxNjQ3LCJuYmYiOjE3MjYzMzA5NjUuODIxNjQ5LCJleHAiOjE3NTc4NjY5NjUuODIwNDk0LCJzdWIiOiI1MzgiLCJzY29wZXMiOltdfQ.j21sgVPAIbw8Z6w7ixHQXp1OXgjCqHJts4JOuwmLV-GahJUeaarXp09iLoEfWHCDP1i9eV7Q07eUGSUnUm-_s7mMNlhZkNjLe0v0lj_rpLYZmf4Zam7jcjl4XPESUcCCdvRayKOYoWnL5i9KT7aoS4zxAmoM_GWuedjm6ogfjI8HreFEkk38e_fLs4M7vfRhVQR8_8-zEQzXAxHB0eAhybmiTpCcsKk7yKlI7PBqH-qAMqmN7TqN9GqRCp17yCY_ItTNFJ2aN4MmESzoQ6QM5q3WnwnntOeAtkRsKMw1ExWkg3kFx0b4Q0M8mvnfb1DZGkd9m_hMb7QSBN6B4K7nicKROVM2u_N67YRD9NySxuyxIOoZQA6E_gJzEd9f5P-79pbzYpbcNm5fIslo8nlPDm5w2VN_hOpokoGUXyRXeXVtKaoU9DOMtxTH0YoccYXQt2MjxwnlM1kJmrtqOPP8Ajn6TIyUi8fXwdeai0wE6a4iBE3yV2R4kYayunlB05x-90lCcWWFvyJ7Ee2wZJwwLr-80iudIoYueteLcTnn82E0CKIxUYL1dmQYMXp3W1NlX1q1LrNREfLqSRqvEhgvFNnhLksyx-vM6B_rHZ-uqzuyuvzCz1VYV2-_vhyCKPjo1WIXR7DL99riQVD_wtF54ptImGISTzUXrcAJYVJS-_A"
        val response = apiCalls.getProfile(token,id)
        return response

    }

    override suspend fun createUser(registerModel: RegisterModel): RegisterNewUserModel {
//        val token="Bearer $token"
        val response = apiCalls.createUser(registerModel)
        return response
    }


}