package com.example.jiadibo.footballmatchschedule.model

data class Favorite(val id: Long?, val teamId: String?, val teamName: String?, val teamBadge: String?) {

    companion object {
        const val TABLE_FAVORITE: String = "FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "MATCH_ID"
        const val HOME_NAME: String = "HOME_NAME"
        const val HOME_ID: String = "HOME_ID"
        const val AWAY_NAME: String = "AWAY_NAME"
        const val AWAY_ID: String = "AWAY_ID"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_SCORE: String = "AWAY_SCORE"


    }
}