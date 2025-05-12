package com.vicsar23.indriverclone.data.dataSource.remote.service

import com.vicsar23.indriverclone.domain.model.AuthResponse
import com.vicsar23.indriverclone.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(
        @Body user: User,
    ): Response<AuthResponse>

}