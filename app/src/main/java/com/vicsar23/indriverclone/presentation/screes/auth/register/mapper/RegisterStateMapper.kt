package com.vicsar23.indriverclone.presentation.screes.auth.register.mapper

import com.vicsar23.indriverclone.domain.model.User
import com.vicsar23.indriverclone.presentation.screes.auth.register.RegisterState

fun RegisterState.toUser() : User{
    return User(
        name = name,
        lastname = lastName,
        email = email,
        phone = phone,
        password = password
    )
}