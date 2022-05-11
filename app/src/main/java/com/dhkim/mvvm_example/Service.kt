package com.dhkim.mvvm_example

import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}