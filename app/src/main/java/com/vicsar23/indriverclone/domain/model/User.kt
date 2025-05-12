package com.vicsar23.indriverclone.domain.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User (
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("image") val image: String? = null,
    @SerializedName("notification_token") val notificationToken: String? = null,
    @SerializedName("roles") val roles: List<Role>? = null,
    @SerializedName("password") val password: String? = null
) : Serializable
