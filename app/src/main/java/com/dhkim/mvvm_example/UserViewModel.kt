package com.dhkim.mvvm_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users : MutableLiveData<List<User>> = MutableLiveData()
    val users : LiveData<List<User>> = _users

    fun fetchData(){

        viewModelScope.launch {

            _users.value = service.getUsers().body()

        }


    }

}