package com.dhkim.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhkim.mvvm_example.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val userViewModel by viewModels<UserViewModel>()
    private val userAdapter by lazy { UserAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        observeData()
        userViewModel.fetchData()

        //fork 111


    }

    private fun initViews() {
        binding.userRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }

    private fun observeData() {
        userViewModel.users.observe(this){
            userAdapter.submitList(it)
        }
    }
}