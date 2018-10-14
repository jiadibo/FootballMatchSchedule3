package com.example.jiadibo.footballmatchschedule.views.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jiadibo.footballmatchschedule.*
import com.example.jiadibo.footballmatchschedule.model.Match
import com.example.jiadibo.footballmatchschedule.views.main.MainAdapter
import com.example.jiadibo.footballmatchschedule.views.main.MainView
import com.example.jiadibo.footballmatchschedule.views.match.MatchDetailActivity
import kotlinx.android.synthetic.main.fragment_second.*
import org.jetbrains.anko.support.v4.startActivity

class SecondFragment : Fragment(), MainView {

    private lateinit var presenter: FragmentPresenter
    private lateinit var adapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = FragmentPresenter(this)
        presenter.getNextMatch()
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showTeamList(data: MutableList<Match>) {
        rv_team.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(data){
            startActivity<MatchDetailActivity>("MATCH_OBJECT" to it)
        }
        rv_team.adapter = adapter
    }
}
