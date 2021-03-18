package com.example.kotlinretrofitsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinretrofitsample.data.repository.UserRepository
import com.example.kotlinretrofitsample.model.User

class MainActivityViewModel : ViewModel() {

    var usersLiveData: MutableLiveData<List<User>>? = null

    fun getUserList() : LiveData<List<User>>? {
        usersLiveData = UserRepository.getUsersApiCall()
        return usersLiveData
    }

}