package com.example.hospitaltry.common.calls.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.calls.data.dataSource.remote.CommonDataSourceImp
import com.example.hospitaltry.common.calls.data.dataSource.remote.ICommonDataSource
import com.example.hospitaltry.common.calls.data.repo.CommonRepoImp
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DICommon {

    @Provides
    @Singleton
    fun provideCommonDataSource(apiCalls: ApiCalls): ICommonDataSource {
        return CommonDataSourceImp(apiCalls)
    }

    @Provides
    @Singleton
    fun provideCommonRepo(commonDataSource: ICommonDataSource):ICommonRepo{
        return CommonRepoImp(commonDataSource)
    }
}