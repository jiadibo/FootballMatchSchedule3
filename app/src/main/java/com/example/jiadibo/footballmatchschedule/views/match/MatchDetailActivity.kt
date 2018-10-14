package com.example.jiadibo.footballmatchschedule.views.match

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.jiadibo.footballmatchschedule.R
import com.example.jiadibo.footballmatchschedule.R.id.add_to_favorite
import com.example.jiadibo.footballmatchschedule.database
import com.example.jiadibo.footballmatchschedule.model.Favorite
import com.example.jiadibo.footballmatchschedule.model.Match
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_match_detail.*
import kotlinx.android.synthetic.main.design_layout_snackbar_include.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class MatchDetailActivity : AppCompatActivity(), DetailView {
    override fun showHomeImage(url: String) {
        Picasso.get().load(url).into(badge_team1)
    }

    override fun showAwayImage(url: String) {
        Picasso.get().load(url).into(badge_team2)
    }

    private lateinit var presenter: DetailPresenter
    lateinit var match: Match

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)


        match = intent.getParcelableExtra<Match>("MATCH_OBJECT")
        date_match.text = match.dateEvent
        team_1.text = match.strHomeTeam
        team_2.text = match.strAwayTeam
        skor_team1.text = match.intHomeScore
        skor_team2.text = match.intAwayScore
        goals1.text = match.strHomeGoalDetails
        goals2.text = match.strAwayGoalDetails
        shots1.text = match.intHomeShots
        shots2.text = match.intAwayShots
        gkeepr1.text = match.strHomeLineupGoalkeeper
        gkeepr2.text = match.strAwayLineupGoalkeeper
        defense1.text = match.strHomeLineupDefense
        defense2.text = match.strAwayLineupDefense
        midfield1.text = match.strHomeLineupMidfield
        midfield2.text = match.strAwayLineupMidfield
        forward1.text = match.strHomeLineupForward
        forward2.text = match.strAwayLineupForward
        subtitus1.text = match.strHomeLineupSubstitutes
        subtitus2.text = match.strAwayLineupSubstitutes


        presenter = DetailPresenter(this)
        presenter.getHomeImage(match.idHomeTeam.toString())
        presenter.getAwayImage(match.idAwayTeam.toString())
    }

    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            add_to_favorite -> {
                addToFavorite(match)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite(match: Match){
        try {
            database.use{
                insert(
                        Favorite.TABLE_FAVORITE,
                        Favorite.MATCH_ID to match.idEvent,
                        Favorite.HOME_ID to match.idHomeTeam,
                        Favorite.AWAY_ID to match.idAwayTeam,
                        Favorite.HOME_NAME to match.strHomeTeam,
                        Favorite.HOME_SCORE to match.intHomeScore,
                        Favorite.AWAY_NAME to match.strAwayTeam,
                        Favorite.AWAY_SCORE to match.intAwayScore,
                        Favorite.DATE_EVENT to match.idEvent

                )

            }
            snackbar(swipeRefreshLayout(),"added to favorite").show()
        }catch (e: SQLiteConstraintException){
            snackbar(swipeRefreshLayout(), e.localizedMessage).show()
        }
    }

}
