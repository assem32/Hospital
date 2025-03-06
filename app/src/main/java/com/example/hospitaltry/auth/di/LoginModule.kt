package com.example.hospitaltry.auth.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.auth.data.dataSource.remote.IAuthDataSource
import com.example.hospitaltry.auth.data.dataSource.remote.AuthDataSourceImp
import com.example.hospitaltry.auth.data.repo.AuthRepoImp
import com.example.hospitaltry.auth.domain.repo.IAuthRepo
import com.example.hospitaltry.auth.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LoginModule {


    @Provides
    @Singleton
    fun getDomainRepo(dataSourceImp: AuthDataSourceImp):IAuthRepo{
        return AuthRepoImp(dataSourceImp)
    }


    @Provides
    @Singleton
    fun getRemoteDataSource(apiCalls: ApiCalls):IAuthDataSource{
        return AuthDataSourceImp(apiCalls)
    }


    @Provides
    @Singleton
    fun provideLoginUseCase(repository: IAuthRepo): LoginUseCase {
        return LoginUseCase(repository)
    }
}