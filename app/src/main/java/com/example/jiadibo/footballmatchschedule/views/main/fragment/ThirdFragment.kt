//package com.example.jiadibo.footballmatchschedule.views.main.fragment
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.support.v7.widget.LinearLayoutManager
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.jiadibo.footballmatchschedule.R
//import com.example.jiadibo.footballmatchschedule.favorite.FavoriteMatchAdapter
//import com.example.jiadibo.footballmatchschedule.model.Favorite
//import com.example.jiadibo.footballmatchschedule.model.Match
//import com.example.jiadibo.footballmatchschedule.views.main.MainView
//import kotlinx.android.synthetic.main.fragment_first.*
//
//
//class ThirdFragment : Fragment(), MainView {
//
////
////    private  var favorites: MutableList<Favorite> = mutableListOf()
////    private lateinit var presenter: FragmentPresenter
////    private lateinit var adapter: FavoriteMatchAdapter
////
////    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
////        return inflater.inflate(R.layout.fragment_third, container, false)
////
////    }
////
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////        presenter = FragmentPresenter(this)
////        presenter.getFavMatch()
////
////    }
////
////    override fun showFavList(data: MutableList<Favorite>) {
////        rv_team.layoutManager = LinearLayoutManager(context)
////        adapter = FavoriteMatchAdapter(data) {
////
////        }
////        rv_team.adapter = adapter
////    }
////
////    override fun showLoading() {
////        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
////    }
////
////    override fun hideLoading() {
////        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
////    }
////
////    override fun showTeamList(data: MutableList<Match>) {
////        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
////    }
////}