package com.example.hospitaltry.reciptionist.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.reciptionist.data.dataSource.remote.ReceptionistRemoteDataSourceImp
import com.example.hospitaltry.reciptionist.data.dataSource.remote.IReceptionistRemoteDataSource
import com.example.hospitaltry.reciptionist.data.repo.ReciptinistRepo
import com.example.hospitaltry.reciptionist.domain.repo.IReceptionistRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReceptionistModule {


    @Provides
    @Singleton
    fun getDoctorRemoteData(apiCalls : ApiCalls):IReceptionistRemoteDataSource{
        return ReceptionistRemoteDataSourceImp(apiCalls)
    }

    @Provides
    @Singleton
    fun getDoctorCallsRepo(iDoctorRemoteDataSource:IReceptionistRemoteDataSource): IReceptionistRepo {
       return ReciptinistRepo(iDoctorRemoteDataSource)
    }
}