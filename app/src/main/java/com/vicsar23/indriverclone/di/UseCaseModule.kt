package com.vicsar23.indriverclone.di

import com.vicsar23.indriverclone.domain.repository.AuthRepository
import com.vicsar23.indriverclone.domain.useCases.auth.AuthUseCase
import com.vicsar23.indriverclone.domain.useCases.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository)
    )

}