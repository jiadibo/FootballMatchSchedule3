package com.example.jiadibo.footballmatchschedule.views.main.fragment

import android.content.Context
import android.util.Log
import com.example.jiadibo.footballmatchschedule.ApiRepository
import com.example.jiadibo.footballmatchschedule.R.string.favorites
import com.example.jiadibo.footballmatchschedule.views.main.MainView
import com.example.jiadibo.footballmatchschedule.model.MatchResponse
import com.example.jiadibo.footballmatchschedule.TheSportDBApi
import com.example.jiadibo.footballmatchschedule.database
import com.example.jiadibo.footballmatchschedule.model.Favorite
import com.google.gson.Gson
import kotlinx.coroutines.experimental.selects.select
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentPresenter(private val view : MainView){
    fun getNextMatch() {
        val service = TheSportDBApi.retrofit.create(ApiRepository::class.java)
        service.listNextMatch().enqueue(object : Callback<MatchResponse> {
            override fun onFailure(call: Call<MatchResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MatchResponse>, response: Response<MatchResponse>) {
                Log.e("RESPONSE", Gson().toJson(response.body()?.events))
                response.body()?.events?.let { view.showTeamList(it) }
            }

        })
    }
    fun getPrevMatch(){
        val service = TheSportDBApi.retrofit.create(ApiRepository::class.java)
        service.listPrevMatch().enqueue(object : Callback<MatchResponse>{
            override fun onFailure(call: Call<MatchResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MatchResponse>, response: Response<MatchResponse>) {
                response.body()?.events?.let { view.showTeamList(it) }
            }

        })
    }

    fun getFavoriteMatch(context: Context?) {
        context?.database?.use {
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            val data: MutableList<Favorite> = mutableListOf()
            data.addAll(favorite)
            view.showFavList(data)
        }
    }

}