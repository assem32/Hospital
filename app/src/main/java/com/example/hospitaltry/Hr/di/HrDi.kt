package com.example.hospitaltry.Hr.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.Hr.data.dataSource.remote.GetDoctorsDataSourceImp
import com.example.hospitaltry.Hr.data.dataSource.remote.IGetDataSourceDoctors
import com.example.hospitaltry.Hr.data.repo.GetAllDoctorsImp
import com.example.hospitaltry.Hr.domain.repo.IGetAllDoctorsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HrDi {


    @Provides
    @Singleton
    fun getDoctorsDataSource(apiCalls: ApiCalls):IGetDataSourceDoctors{
        return GetDoctorsDataSourceImp(apiCalls)
    }

    @Provides
    @Singleton
    fun getDoctorsRepo(iGetDataSourceDoctors: IGetDataSourceDoctors):IGetAllDoctorsRepo{
        return GetAllDoctorsImp(iGetDataSourceDoctors)
    }
}