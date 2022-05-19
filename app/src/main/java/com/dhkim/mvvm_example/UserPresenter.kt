package com.dhkim.mvvm_example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserPresenter @Inject constructor(
    private val view: UserContract.View,
    private val repository: Repository
) : UserContract.Presenter {

    override suspend fun getUsers() {
        withContext(Dispatchers.IO) {
            view.showUsers(repository.getUsers())
        }
    }
}