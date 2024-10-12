package com.example.hospitaltry.login.di

import com.example.hospitaltry.Api.ApiCalls
import com.example.hospitaltry.login.data.dataSource.remote.ILoginDataSource
import com.example.hospitaltry.login.data.dataSource.remote.LoginDataSourceImp
import com.example.hospitaltry.login.data.repo.LoginRepo
import com.example.hospitaltry.login.domain.repo.ILoginRepo
import com.example.hospitaltry.login.domain.usecase.LoginUseCase
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
    fun getDomainRepo(dataSourceImp: LoginDataSourceImp):ILoginRepo{
        return LoginRepo(dataSourceImp)
    }


    @Provides
    @Singleton
    fun getRemoteDataSource(apiCalls: ApiCalls):ILoginDataSource{
        return LoginDataSourceImp(apiCalls)
    }


    @Provides
    @Singleton
    fun provideLoginUseCase(repository: ILoginRepo): LoginUseCase {
        return LoginUseCase(repository)
    }
}