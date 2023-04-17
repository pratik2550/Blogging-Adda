package com.example.retrofit2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit2.api.SimpleApi
import com.example.retrofit2.model.Post
import com.example.retrofit2.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Post> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response: Post = repository.getPost()
            myResponse.value = response
        }
    }

}