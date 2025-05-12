package com.vicsar23.indriverclone.di

import com.vicsar23.indriverclone.domain.repository.AuthRepository
import com.vicsar23.indriverclone.domain.useCases.auth.AuthUseCases
import com.vicsar23.indriverclone.domain.useCases.auth.LoginUseCase
import com.vicsar23.indriverclone.domain.useCases.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCases(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository)
    )

}