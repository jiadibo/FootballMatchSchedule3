package com.example.jiadibo.footballmatchschedule.views.match

import com.example.jiadibo.footballmatchschedule.ApiRepository
import com.example.jiadibo.footballmatchschedule.TheSportDBApi
import com.example.jiadibo.footballmatchschedule.model.DetailResponse
import com.example.jiadibo.footballmatchschedule.views.main.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(private val view: DetailView) {
    fun getHomeImage(id: String) {
        val service = TheSportDBApi.retrofit.create(ApiRepository::class.java)
        service.teamDetail(id).enqueue(object : Callback<DetailResponse> {
            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                response.body()?.events?.let { view.showHomeImage(it[0].strTeamBadge.toString()) }
            }

        })
    }

    fun getAwayImage(id: String) {
        val service = TheSportDBApi.retrofit.create(ApiRepository::class.java)
        service.teamDetail(id).enqueue(object : Callback<DetailResponse> {
            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                response.body()?.events?.let { view.showAwayImage(it[0].strTeamBadge.toString()) }
            }

        })
    }
}