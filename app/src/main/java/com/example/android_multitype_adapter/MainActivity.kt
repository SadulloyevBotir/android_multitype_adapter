package com.example.android_multitype_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_multitype_adapter.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userList()
        initViews()
    }

    private fun initViews() {
        userAdapter = Adapter()
        userAdapter.addItems(userList())
        binding.rvUser.adapter = userAdapter
        binding.rvUser.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
    }

    private fun userList(): ArrayList<User> {
        var list = ArrayList<User>()
        for (i in 1..55) {
            if (i % 5 == 0) {
                list.add(User(true))
            } else {
                list.add(User(false))
            }
        }
        return list
    }
}