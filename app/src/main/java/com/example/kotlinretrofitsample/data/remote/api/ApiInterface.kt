package com.example.kotlinretrofitsample.data.remote.api

import com.example.kotlinretrofitsample.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("services")
    fun getServices() : Call<ServicesSetterGetter>

}