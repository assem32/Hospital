package com.example.hospitaltry.common.cases.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.calls.data.dataSource.remote.CommonDataSourceImp
import com.example.hospitaltry.common.calls.data.dataSource.remote.ICommonDataSource
import com.example.hospitaltry.common.calls.data.repo.CommonRepoImp
import com.example.hospitaltry.common.cases.data.dataSource.CasesDataSource
import com.example.hospitaltry.common.cases.data.repo.CasesRepoImp
import com.example.hospitaltry.common.cases.domain.repo.ICasesRepo
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CasesDI {

    @Provides
    @Singleton
    fun provideCasesDataSource(apiCalls: ApiCalls): CasesDataSource {
        return CasesDataSource(apiCalls)
    }

    @Provides
    @Singleton
    fun provideCommonRepo(casesDataSource: CasesDataSource): ICasesRepo {
        return CasesRepoImp(casesDataSource)
    }
}