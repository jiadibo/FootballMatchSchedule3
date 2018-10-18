package com.example.jiadibo.footballmatchschedule.favorite

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jiadibo.footballmatchschedule.R
import com.example.jiadibo.footballmatchschedule.model.Favorite
import kotlinx.android.synthetic.main.list_item_view.view.*
import org.jetbrains.anko.find

class FavoriteMatchAdapter (private val favorite: List<Favorite>,
                            private val listener: (Favorite)-> Unit)
    : RecyclerView.Adapter<FavoriteMatchAdapter.FavoriteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(favorite[position], listener)
    }


    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val teamName1: TextView = view.find(R.id.team_Home)
        private val teamName2: TextView = view.find(R.id.team_Away)
        private val teamSkor1: TextView = view.find(R.id.skor_teamHome)
        private val teamSkor2: TextView = view.find(R.id.skor_teamAway)
        private val dateMatch: TextView = view.find(R.id.date_match)

        fun bindItem(favorite: Favorite, listener: (Favorite) -> Unit) {

            dateMatch.text = favorite.DATE_EVENT
            teamName1.text = favorite.HOME_NAME
            teamSkor1.text = favorite.HOME_SCORE
            teamSkor2.text = favorite.AWAY_SCORE
            teamName2.text = favorite.AWAY_NAME
            itemView.setOnClickListener {
                listener(favorite)
            }
        }
    }
}

