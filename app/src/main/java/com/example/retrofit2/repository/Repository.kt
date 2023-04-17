package com.example.retrofit2.repository

import com.example.retrofit2.api.RetrofitInstance
import com.example.retrofit2.model.Post

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}