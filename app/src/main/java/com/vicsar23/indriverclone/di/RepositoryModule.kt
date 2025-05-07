package com.vicsar23.indriverclone.di

import com.vicsar23.indriverclone.data.dataSource.remote.service.AuthService
import com.vicsar23.indriverclone.data.repository.AuthRepositoryImpl
import com.vicsar23.indriverclone.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(authService: AuthService) : AuthRepository = AuthRepositoryImpl(authService)

}