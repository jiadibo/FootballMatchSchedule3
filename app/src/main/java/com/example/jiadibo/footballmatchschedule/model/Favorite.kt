package com.example.jiadibo.footballmatchschedule.model

data class Favorite(
        val ID: Long?,
        val DATE_EVENT: String?,
        val HOME_NAME: String?,
        val HOME_SCORE: String?,
        val AWAY_SCORE: String?,
        val AWAY_NAME: String?,
        val MATCH_ID: String?,
        val HOME_ID: String?,
        val AWAY_ID: String?

) {

    companion object {
        const val TABLE_FAVORITE: String = "FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "MATCH_ID"
        const val HOME_ID: String = "HOME_ID"
        const val AWAY_ID: String = "AWAY_ID"
        const val HOME_NAME: String = "HOME_NAME"
        const val AWAY_NAME: String = "AWAY_NAME"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_SCORE: String = "AWAY_SCORE"
        const val DATE_EVENT: String = "DATE_EVENT"


    }
}