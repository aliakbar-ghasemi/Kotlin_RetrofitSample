package com.example.kotlinretrofitsample.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinretrofitsample.data.remote.api.ApiRemoteDataSource
import com.example.kotlinretrofitsample.data.remote.api.RetrofitClient
import com.example.kotlinretrofitsample.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val apiRemoteDataSource: ApiRemoteDataSource) {

    suspend fun getUsers() = apiRemoteDataSource.getUsers()

    /*val users = MutableLiveData<List<User>>()

    fun getUsersApiCall(): MutableLiveData<List<User>> {

        val call = RetrofitClient.apiInterface.getUsers()

        call.enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                    call: Call<List<User>>,
                    response: Response<List<User>>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()
                users.value = data
            }
        })

        return users
    }*/
}
