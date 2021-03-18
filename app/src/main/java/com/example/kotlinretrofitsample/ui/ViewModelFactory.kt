package com.example.kotlinretrofitsample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinretrofitsample.data.remote.api.ApiInterface
import com.example.kotlinretrofitsample.data.remote.api.ApiRemoteDataSource
import com.example.kotlinretrofitsample.data.repository.UserRepository

class ViewModelFactory(private val apiInterface: ApiInterface) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(UserRepository(ApiRemoteDataSource(apiInterface))) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}