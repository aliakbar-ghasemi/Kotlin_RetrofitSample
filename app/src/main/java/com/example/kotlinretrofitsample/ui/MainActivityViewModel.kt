package com.example.kotlinretrofitsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlinretrofitsample.data.remote.Resource
import com.example.kotlinretrofitsample.data.repository.UserRepository
import com.example.kotlinretrofitsample.model.User
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = userRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    /*var usersLiveData: MutableLiveData<List<User>>? = null

    fun getUserList() : LiveData<List<User>>? {
        usersLiveData = UserRepository.getUsersApiCall()
        return usersLiveData
    }*/

}