package com.example.hospitaltry.Api

import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileModel
import com.example.hospitaltry.auth.data.model.LoginRequest
import com.example.hospitaltry.reciptionist.data.model.ReciptanistCallsModel
import com.example.hospitaltry.auth.data.model.UserModel
import com.example.hospitaltry.reciptionist.data.model.CallDetailsModel
import com.example.hospitaltry.reciptionist.data.model.CreateCallResp
import com.example.hospitaltry.reciptionist.domain.model.CallCreateEntitiy
import com.example.hospitaltry.reciptionist.domain.model.CallEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
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

}