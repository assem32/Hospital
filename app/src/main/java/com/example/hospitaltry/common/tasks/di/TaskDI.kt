package com.example.hospitaltry.common.tasks.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.common.calls.data.dataSource.remote.CommonDataSourceImp
import com.example.hospitaltry.common.calls.data.dataSource.remote.ICommonDataSource
import com.example.hospitaltry.common.calls.data.repo.CommonRepoImp
import com.example.hospitaltry.common.tasks.data.dataSource.remote.ITasksDataSource
import com.example.hospitaltry.common.tasks.data.dataSource.remote.TasksDataSourceImp
import com.example.hospitaltry.common.tasks.data.repo.TasksRepoImp
import com.example.hospitaltry.common.tasks.domain.repo.ITasksRepo
import com.example.hospitaltry.doctor.domain.repo.ICommonRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TaskDI {

    @Provides
    @Singleton
    fun provideTasksDataSource(apiCalls: ApiCalls): ITasksDataSource {
        return TasksDataSourceImp(apiCalls)
    }

    @Provides
    @Singleton
    fun provideTasksRepo(commonDataSource: ITasksDataSource): ITasksRepo {
        return TasksRepoImp(commonDataSource)
    }
}