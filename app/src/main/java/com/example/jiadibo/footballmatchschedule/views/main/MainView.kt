package com.example.jiadibo.footballmatchschedule.views.main

import com.example.jiadibo.footballmatchschedule.model.Favorite
import com.example.jiadibo.footballmatchschedule.model.Match

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: MutableList<Match>)
    fun showFavList(data: MutableList<Favorite>)

}