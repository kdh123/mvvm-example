package com.dhkim.mvvm_example

interface Repository{

    suspend fun getUsers() : List<User>

}