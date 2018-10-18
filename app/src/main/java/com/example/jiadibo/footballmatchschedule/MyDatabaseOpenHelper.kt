package com.example.jiadibo.footballmatchschedule

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.jiadibo.footballmatchschedule.model.Favorite
import org.jetbrains.anko.db.*


class MyDatabaseOpenHelper(ctx: Context): ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 1)
    {
        companion object {
            private var instances: MyDatabaseOpenHelper? = null

            @Synchronized
            fun getInstance(ctx: Context): MyDatabaseOpenHelper{
                if (instances == null){
                    instances = MyDatabaseOpenHelper(ctx.applicationContext)
                }

                return instances as MyDatabaseOpenHelper
            }
        }


        override fun onCreate(p0: SQLiteDatabase?) {
        //disini membuat tabel
            p0?.createTable(Favorite.TABLE_FAVORITE, true,
                    Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                    Favorite.MATCH_ID to TEXT+ UNIQUE,
                    Favorite.HOME_ID to TEXT,
                    Favorite.AWAY_ID to TEXT,
                    Favorite.HOME_NAME to TEXT,
                    Favorite.AWAY_NAME to TEXT,
                    Favorite.HOME_SCORE to TEXT,
                    Favorite.AWAY_SCORE to TEXT,
                    Favorite.DATE_EVENT to TEXT
                    )
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            //upgrade tabel
            p0?.dropTable(Favorite.TABLE_FAVORITE, true)
        }
    }
//access property untuk context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)