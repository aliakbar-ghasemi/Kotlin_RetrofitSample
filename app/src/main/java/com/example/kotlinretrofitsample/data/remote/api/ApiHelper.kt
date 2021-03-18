package com.example.kotlinretrofitsample.data.remote.api

class ApiRemoteDataSource(private val apiInterface: ApiInterface) {

    suspend fun getUsers() = apiInterface.getUsers()
}