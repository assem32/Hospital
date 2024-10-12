package com.example.hospitaltry.Api.di

import com.example.hospitaltry.Api.ApiCalls
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://hospital.elhossiny.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Provides
    @Singleton
    fun getApiCalls(retrofit: Retrofit):ApiCalls{
        return retrofit.create(ApiCalls::class.java)
    }

}