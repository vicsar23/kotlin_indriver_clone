package com.vicsar23.indriverclone.domain.repository

import com.vicsar23.indriverclone.domain.model.AuthResponse
import com.vicsar23.indriverclone.domain.util.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
}