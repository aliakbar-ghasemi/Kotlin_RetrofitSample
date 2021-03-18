package com.example.kotlinretrofitsample.data.remote.api

import com.example.kotlinretrofitsample.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    //fun getUsers() : Call<List<User>>
    suspend fun getUsers() : List<User>

}