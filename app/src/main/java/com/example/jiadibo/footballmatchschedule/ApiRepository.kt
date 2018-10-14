package com.example.jiadibo.footballmatchschedule

import com.example.jiadibo.footballmatchschedule.model.DetailResponse
import com.example.jiadibo.footballmatchschedule.model.MatchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName


interface ApiRepository {
    @GET("/api/v1/json/1/eventsnextleague.php?id=4328")
    fun listNextMatch(): Call<MatchResponse>
    @GET("/api/v1/json/1/eventspastleague.php?id=4328")
    fun listPrevMatch(): Call<MatchResponse>
    @GET("api/v1/json/1/lookupteam.php")
    fun teamDetail(@Query("id") id:String): Call<DetailResponse>


}