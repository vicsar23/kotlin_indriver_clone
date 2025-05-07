package com.vicsar23.indriverclone.domain.useCases.auth

import com.vicsar23.indriverclone.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}