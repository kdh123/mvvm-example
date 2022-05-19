package com.dhkim.mvvm_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _users : MutableLiveData<List<User>> = MutableLiveData()
    val users : LiveData<List<User>> = _users

    fun fetchData(){

        viewModelScope.launch {

            _users.value = repository.getUsers()

        }


    }

}