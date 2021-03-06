package com.dhkim.mvvm_example

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: String,
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val imageUrl: String,
)
