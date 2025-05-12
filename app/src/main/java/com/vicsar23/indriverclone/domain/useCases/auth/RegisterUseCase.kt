package com.vicsar23.indriverclone.domain.useCases.auth

import com.vicsar23.indriverclone.domain.model.User
import com.vicsar23.indriverclone.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.register(user)
}