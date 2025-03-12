package com.example.hospitaltry.common.tasks.data.dataSource.remote

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel
import com.example.hospitaltry.user
import javax.inject.Inject

class TasksDataSourceImp @Inject constructor(val apiCalls: ApiCalls):ITasksDataSource {
    override suspend fun getTasks() :AllTasksRespons{
        val token="Bearer ${user.accessToken}"
        val response = apiCalls.getTasks(token,"2025-03-09")
        return  response
    }

    override suspend fun getTasksDetails(id: Int): TaskDetailsModel {
        val token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMjFmMWIxYjUxODQ3ZTcwODgzNjZjOGQwNTkyMjUyN2ZmMzFhN2Y1NzQxNjlkMGI3OGY1MGY3YmFmM2QzMGMyZjkzMTJlZDJlOGFhZDAxZjciLCJpYXQiOjE3NDE2OTY1OTguMDY0Mzc3LCJuYmYiOjE3NDE2OTY1OTguMDY0Mzc4LCJleHAiOjE3NzMyMzI1OTguMDYwODI1LCJzdWIiOiIxMzgiLCJzY29wZXMiOltdfQ.y2hYoXhcj3aX6E_S8spRT-P_fTngHgzoRp67WJdaWEfWHxgWDAX6yCkSOAyuCPejVFgW-axoyR-8awJnqGK43hFKPEHGJmYa81h3nuPeedZ07T2Y-ueqh33WfwNVd7mD6A5BHX_t_tB5nNAd0foth06m5BqUwxoxAQZhkBYrMc4q0Ck7olJEJPTpLbEXR0wle6SXF8e4wL55fsEJkXv3YVDsP32tlS5a6XrlUi77Ia-Pns5iLHioiIpiSHEOPEvz2JJW2BthIpkLyOeZFUDwe2Z_X712KeoA5dNmKQ4hKbqTOwWkTceR9Vx3OMIzUOGQCuPiqwP_YH-7jZPCvPETaNwywRcph1Uk8lFRYe8ipvf5Ey-g6I0bWTyDuQlsEf7u9_euultkuH016_CO8Wcz9-hJ62tsWls_pXBar-E7G1ojJ6ehErctziBB2OC1Y5KGQWwpmss2HfP3S4pf4z4PL8ZnefvoLhL1_HXGzFV7YEh0HyJcOWeBtplqYoIXkHrZEFjoqal7r_vR4UbBdJwXuVktrmXJOBtVtJ1flsS0SuMLpGRoSNH64uLHzKiNcHKDDb1Z66Ns9wRKlWz6l-xgxnw0uGldTHf16CaEAaqQYsBG6E1WXpAB_7Op1aRoVz8DB2cx_e-d6bjE2K4mNcN9Kjwqbm2-u5EOPSZuWZwPlK0"
        val response = apiCalls.getTaskDetails(token,id)
        return response
    }
}