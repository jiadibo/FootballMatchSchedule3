package com.example.jiadibo.footballmatchschedule

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object TheSportDBApi {
    val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}