package com.dhkim.mvvm_example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositoryImpl @Inject constructor(private val service: Service) : Repository{

    override suspend fun getUsers(): List<User> {

        val users: List<User>

        withContext(Dispatchers.IO){
            users = service.getUsers().body()?.let {
                it
            } ?: emptyList()
        }

        return users

    }
}