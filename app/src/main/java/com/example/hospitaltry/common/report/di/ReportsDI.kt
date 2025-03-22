package com.example.hospitaltry.common.report.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.report.data.dataSource.ReportsDataSource
import com.example.hospitaltry.common.report.data.repo.RepoImp
import com.example.hospitaltry.common.report.domain.repo.IReport
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ReportsDI {

    @Provides
    @Singleton
    fun provideReportsDataSource(apiCalls: ApiCalls): ReportsDataSource {
        return ReportsDataSource(apiCalls)
    }

    @Provides
    @Singleton
    fun provideReportRepo(reportsDataSource: ReportsDataSource): IReport {
        return RepoImp(reportsDataSource)
    }

}