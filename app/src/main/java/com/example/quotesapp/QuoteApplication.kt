package com.example.quotesapp

import android.app.Application
import com.example.quotesapp.api.QuoteService
import com.example.quotesapp.api.RetrofitHelper
import com.example.quotesapp.database.QuoteDatabase
import com.example.quotesapp.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository= QuoteRepository(quoteService, database, applicationContext)
    }
}