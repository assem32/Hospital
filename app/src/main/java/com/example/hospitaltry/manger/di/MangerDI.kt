package com.example.hospitaltry.manger.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.Hr.data.dataSource.remote.GetDoctorsDataSourceImp
import com.example.hospitaltry.Hr.data.dataSource.remote.IGetDataSourceDoctors
import com.example.hospitaltry.Hr.data.repo.HrImp
import com.example.hospitaltry.Hr.domain.repo.IHrRepo
import com.example.hospitaltry.manger.data.remote.MangerDataSource
import com.example.hospitaltry.manger.data.repo.MangerRepo
import com.example.hospitaltry.manger.domain.repo.IMangerRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MangerDI {

    @Provides
    @Singleton
    fun getMangerDataSource(apiCalls: ApiCalls):MangerDataSource{
        return MangerDataSource(apiCalls)
    }


    @Provides
    @Singleton
    fun getMangerRepo(iMangerRepo: MangerDataSource): IMangerRepo {
        return MangerRepo(iMangerRepo)
    }
}