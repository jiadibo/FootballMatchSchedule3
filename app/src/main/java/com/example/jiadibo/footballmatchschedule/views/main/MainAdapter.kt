package com.example.jiadibo.footballmatchschedule.views.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jiadibo.footballmatchschedule.R
import com.example.jiadibo.footballmatchschedule.model.Match
import org.jetbrains.anko.find

class MainAdapter(private val teams: MutableList<Match>,
                  private val listener: (Match) -> Unit) : RecyclerView.Adapter<MainAdapter.TeamViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, p0, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }


    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val teamName1: TextView = view.find(R.id.team_1)
        private val teamName2: TextView = view.find(R.id.team_2)
        private val teamSkor1: TextView = view.find(R.id.skor_team1)
        private val teamSkor2: TextView = view.find(R.id.skor_team2)
        private val dateMatch: TextView = view.find(R.id.date_match)

        fun bindItem(teams: Match, listener: (Match) -> Unit) {
            teamName1.text = teams.strHomeTeam
            teamName2.text = teams.strAwayTeam
            teamSkor1.text = teams.intHomeScore
            teamSkor2.text = teams.intAwayScore
            dateMatch.text = teams.dateEvent
            itemView.setOnClickListener {
                listener(teams)
            }

        }
    }
}

