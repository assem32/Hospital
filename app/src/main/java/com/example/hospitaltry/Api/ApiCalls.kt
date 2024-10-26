package com.example.hospitaltry.Api

import com.example.hospitaltry.Hr.data.model.DoctorResp
import com.example.hospitaltry.Hr.data.model.ProfileModel
import com.example.hospitaltry.doctor.data.model.AcceptAndDeclineModel
import com.example.hospitaltry.doctor.data.model.CallDetail
import com.example.hospitaltry.doctor.data.model.CallDetailsModel
import com.example.hospitaltry.doctor.data.model.DoctorCallsModel
import com.example.hospitaltry.login.data.model.UserModel
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
    suspend fun getDoctorCalls(@Header ("Authorization") token:String):DoctorCallsModel


    @PUT("calls-accept/{id}")
    suspend fun acceptDeclineCall(@Header ("Authorization") token:String, @Path("id") callId: String, @Body status :String): AcceptAndDeclineModel

    @GET("calls/{id}")
    suspend fun getCallDetails(@Header ("Authorization") token:String, @Path("id") callId: String): CallDetailsModel

}