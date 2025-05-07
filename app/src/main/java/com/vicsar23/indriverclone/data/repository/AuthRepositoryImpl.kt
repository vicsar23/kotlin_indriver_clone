package com.vicsar23.indriverclone.data.repository

import android.util.Log
import com.vicsar23.indriverclone.data.dataSource.remote.service.AuthService
import com.vicsar23.indriverclone.domain.model.AuthResponse
import com.vicsar23.indriverclone.domain.repository.AuthRepository
import com.vicsar23.indriverclone.domain.util.Resource

class AuthRepositoryImpl(private val authService: AuthService): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authService.login(email, password)
            if (result.isSuccessful) {
                Log.d("AuthRepositoryImpl", "Data Success: ${ result.body() }")
                Resource.Success(result.body()!!)
            }
            else {
                Log.d("AuthRepositoryImpl", "Error en la peticion")
                Resource.Failure("Error en la peticion")
            }
        } catch (e: Exception) {
            Log.d("AuthRepositoryImpl", "Message: ${e}")
            Log.d("AuthRepositoryImpl", "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }

}