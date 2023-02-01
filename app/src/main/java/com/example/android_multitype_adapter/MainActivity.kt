package com.example.android_multitype_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

    }

    private fun userList(): ArrayList<User> {
        var list = ArrayList<User>()
        for (i in 0..55) {
            if (i % 5 == 0) {
                list.add(User(true))
            } else {
                list
            }
        }
        return list
    }
}