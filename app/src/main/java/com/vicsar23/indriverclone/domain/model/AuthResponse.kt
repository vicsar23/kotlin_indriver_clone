package com.vicsar23.indriverclone.domain.model

data class AuthResponse (
    val user: User? = null,
    val token: String? = null
)