package com.dhkim.mvvm_example

class UserContract {

    interface View{
        suspend fun showUsers(users: List<User>)
    }

    interface Presenter{
        suspend fun getUsers()
    }

}