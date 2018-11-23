package com.example.jiadibo.footballmatchschedule.views.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.jiadibo.footballmatchschedule.*
import com.example.jiadibo.footballmatchschedule.favorite.FavoriteMatchAdapter
import com.example.jiadibo.footballmatchschedule.model.Const.Companion.HOME_ID
import com.example.jiadibo.footballmatchschedule.model.Favorite
import com.example.jiadibo.footballmatchschedule.model.Match
import com.example.jiadibo.footballmatchschedule.views.main.MainAdapter
import com.example.jiadibo.footballmatchschedule.views.main.MainView
import com.example.jiadibo.footballmatchschedule.views.match.MatchDetailActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_second.*
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.startActivity


class Fragment : Fragment(), MainView {


    enum class Mode {
        DEFAULT, FAVORITE, PREVIOUS
    }

    var mode: Mode = Mode.DEFAULT

    private  var favorites: MutableList<Favorite> = mutableListOf()
    private lateinit var presenter: FragmentPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = FragmentPresenter(this)
        when(mode) {
            Mode.DEFAULT -> presenter.getNextMatch()
            Mode.PREVIOUS -> presenter.getPrevMatch()
            Mode.FAVORITE -> context?.let { presenter.getFavoriteMatch(it) }
        }
    }

    override fun showLoading() {

        }

    override fun hideLoading() {
        }

    override fun showTeamList(data: MutableList<Match>) {
        Log.e("BukanDetailAkitiviti", "${data}")
        rv_team.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(data){
            startActivity<MatchDetailActivity>(
                    "idEvent" to it.idEvent,
                    "idHomeTeam" to it.idHomeTeam,
                    "idAwayTeam" to it.idAwayTeam)
        }
        rv_team.adapter = adapter
    }

    override fun showFavList(data: MutableList<Favorite>) {

        Log.e("FAVORITE_DATA", Gson().toJson(data))

        rv_team.layoutManager = LinearLayoutManager(context)
        rv_team.adapter = FavoriteMatchAdapter(data){
            startActivity<MatchDetailActivity>(
                    "idEvent" to "${it.MATCH_ID}",
                    "idHomeTeam" to "${it.HOME_ID}",
                    "idAwayTeam" to "${it.AWAY_ID}")
        }

    }

}
