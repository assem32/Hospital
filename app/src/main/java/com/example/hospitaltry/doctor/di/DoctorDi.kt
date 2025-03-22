package com.example.hospitaltry.doctor.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.doctor.data.dataSource.remote.DoctorDataSourceImp
import com.example.hospitaltry.doctor.data.dataSource.remote.IDoctorDataSource
import com.example.hospitaltry.doctor.data.repo.DoctorRepoImp
import com.example.hospitaltry.doctor.domain.repo.IDoctorRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DoctorDi  {

    @Provides
    @Singleton
     fun provideDoctorDataSource(apiCalls: ApiCalls):IDoctorDataSource{
        return DoctorDataSourceImp(apiCalls)
    }

    @Provides
    @Singleton
     fun provideDoctorRepo( iDoctorDataSource: IDoctorDataSource):IDoctorRepo{
        return DoctorRepoImp(iDoctorDataSource)
    }
}