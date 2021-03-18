package com.example.kotlinretrofitsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinretrofitsample.R
import com.example.kotlinretrofitsample.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btnClick.setOnClickListener {

            mainActivityViewModel.getUserList()?.observe(this, Observer { users ->
                updateUI(users);
            })

        }

    }

    private fun updateUI(users: List<User>?) {
        var data = "";
        if (users != null) {
            for (user in users)
                data += user.name + "\n"
        }
        lblResponse.text = data
    }
}