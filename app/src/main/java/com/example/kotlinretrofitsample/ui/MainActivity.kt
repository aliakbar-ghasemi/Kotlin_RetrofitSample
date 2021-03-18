package com.example.kotlinretrofitsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinretrofitsample.R
import com.example.kotlinretrofitsample.data.remote.Status
import com.example.kotlinretrofitsample.data.remote.api.ApiInterface
import com.example.kotlinretrofitsample.data.remote.api.RetrofitClient
import com.example.kotlinretrofitsample.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupObservers()

        /*viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btnClick.setOnClickListener {
            viewModel.getUserList()?.observe(this, Observer { users ->
                updateUI(users);
            })
        }*/
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(RetrofitClient.apiInterface)
        ).get(MainActivityViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        //recyclerView.visibility = View.VISIBLE
                        //progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        //recyclerView.visibility = View.VISIBLE
                        //progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        //progressBar.visibility = View.VISIBLE
                        //recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<User>) {
        var data = "";
        for (user in users)
            data += user.name + "\n"
        lblResponse.text = data
    }

    /*private fun updateUI(users: List<User>?) {
        var data = "";
        if (users != null) {
            for (user in users)
                data += user.name + "\n"
        }
        lblResponse.text = data
    }*/
}