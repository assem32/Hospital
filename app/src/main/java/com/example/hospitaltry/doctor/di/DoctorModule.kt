package com.example.hospitaltry.doctor.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.doctor.data.dataSource.remote.DoctorRemoteDataSourceImp
import com.example.hospitaltry.doctor.data.dataSource.remote.IDoctorRemoteDataSource
import com.example.hospitaltry.doctor.data.repo.DoctorsRepo
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DoctorModule {


    @Provides
    @Singleton
    fun getDoctorRemoteData(apiCalls : ApiCalls):IDoctorRemoteDataSource{
        return DoctorRemoteDataSourceImp(apiCalls)
    }

    @Provides
    @Singleton
    fun getDoctorCallsRepo(iDoctorRemoteDataSource:IDoctorRemoteDataSource): IDoctorRepo {
       return DoctorsRepo(iDoctorRemoteDataSource)
    }
}