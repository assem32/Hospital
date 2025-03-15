package com.example.hospitaltry.Api

import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileModel
import com.example.hospitaltry.Hr.data.model.RegisterNewUserModel
import com.example.hospitaltry.Hr.domain.model.RegisterModel
import com.example.hospitaltry.auth.data.model.LoginRequest
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.auth.data.model.UserModel
import com.example.hospitaltry.common.cases.data.model.CaseDetailsModel
import com.example.hospitaltry.common.cases.data.model.CasesModel
import com.example.hospitaltry.common.tasks.data.model.AllTasksRespons
import com.example.hospitaltry.common.tasks.data.model.TaskDetailsModel
import com.example.hospitaltry.doctor.data.model.AcceptOrRejectModel
import com.example.hospitaltry.manger.data.model.CreateTaskModel
import com.example.hospitaltry.manger.data.model.CreateTaskResponse
import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCalls {

    @POST("login")
    suspend fun login(@Body  loginRequest: LoginRequest): UserModel


    @GET("doctors")
    suspend fun getDoctors(@Header ("Authorization") token :String,@Query("type") type :String = "doctor"):DoctorResp

    @POST("show-profile")
    suspend fun  getProfile(@Header ("Authorization") token :String,@Query ("user_id") user_id:String):ProfileModel


    @GET("calls")
    suspend fun getAllCalls(@Header ("Authorization") token:String):ReciptanistCallsModel

    @GET("calls/{id}")
    suspend fun getCallDetails(@Path("id") id:Int,@Header ("Authorization") token:String,):CallDetailsModel

    @POST("calls")
    suspend fun createCall(@Header ("Authorization") token:String ,@Body callEntity: CallCreateEntitiy):CreateCallResp


    @POST("register")
    suspend fun createUser(@Body registerModel: RegisterModel):RegisterNewUserModel

    @PUT("calls-accept/{id}")
    suspend fun acceptOrReject(@Header ("Authorization") token:String,@Path("id") id:Int):AcceptOrRejectModel

    @GET("tasks")
    suspend fun getTasks(@Header ("Authorization") token:String,@Query ("date") date:String):AllTasksRespons

    @GET("tasks/{id}")
    suspend fun getTaskDetails(@Header ("Authorization") token:String,@Path ("id") id:Int):TaskDetailsModel

    @POST("tasks")
    suspend fun createTask(@Header ("Authorization") token:String,@Body createTaskModel: CreateTaskModel):CreateTaskResponse


    @GET("case")
    suspend fun getCases(@Header ("Authorization") token:String,):CasesModel

    @GET("case/{id}")
    suspend fun getCaseDetails(@Header ("Authorization") token:String,@Path ("id") id:Int):CaseDetailsModel
}