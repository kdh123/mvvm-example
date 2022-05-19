package com.dhkim.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhkim.mvvm_example.databinding.ActivityMainBinding
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.jetbrains.annotations.Contract
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UserContract.View {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    private val userViewModel by viewModels<UserViewModel>()
    private val userAdapter by lazy { UserAdapter() }

    @Inject
    lateinit var presenter: UserContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        //observeData()


        //userViewModel.fetchData()


        fetchData()


    }


    private fun fetchData() {
        lifecycleScope.launch {
            presenter.getUsers()
        }


    }

    private fun initViews() {
        binding.userRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }

    private fun observeData() {
       /* userViewModel.users.observe(this){
            userAdapter.submitList(it)
        }*/
    }

    override suspend fun showUsers(users: List<User>) {
        lifecycleScope.launch {
            userAdapter.submitList(users)
        }
    }
}