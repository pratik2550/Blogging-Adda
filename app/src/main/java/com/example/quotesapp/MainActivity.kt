package com.example.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.api.QuoteService
import com.example.quotesapp.api.RetrofitHelper
import com.example.quotesapp.repository.QuoteRepository
import com.example.quotesapp.viewmodels.MainViewModel
import com.example.quotesapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel=  ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this) {
            Log.i("PratikQuotes", it.results[1].tags[0])
        }

    }
}