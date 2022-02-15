package com.soarsy.ktdemo.mvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.soarsy.ktdemo.R
import com.soarsy.ktdemo.mvvm.ui.adapter.HomeAdapter
import com.soarsy.ktdemo.mvvm.utlis.SharedPref
import com.soarsy.ktdemo.mvvm.utlis.SharedPrefCont
import com.soarsy.ktdemo.mvvm.vm.HomeViewModel

/**
 * NAME：YONG_
 * Created at: 2022/2/14 18
 * Describe:
 */
class GithubHomeFragment:BaseFragment(){

 private lateinit var toolbar:Toolbar
 private lateinit var mRecyclerView: RecyclerView
 private lateinit var fabTop: FloatingActionButton
 private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout

 private lateinit var vm:HomeViewModel

 override val layoutId: Int= R.layout.fragment_github_home

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  findView(view)
  binds()
  //请求数据
  inReposData(HomeViewModel.sortByUpdate)
 }

 private fun findView(view:View) {
  toolbar = view.findViewById(R.id.toolbar)
  mRecyclerView = view.findViewById(R.id.mRecyclerView)
  fabTop = view.findViewById(R.id.fabTop)
  mSwipeRefreshLayout = view.findViewById(R.id.mSwipeRefreshLayout)
 }

 private fun binds() {
  toolbar.inflateMenu(R.menu.menu_repos_filter_type)

  vm = ViewModelProvider(this).get(HomeViewModel::class.java)

  toolbar.setOnMenuItemClickListener {
   onMenuSelected(it)
   true
  }

  fabTop.setOnClickListener {
   mRecyclerView.scrollToPosition(0)
  }

  mSwipeRefreshLayout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
   inReposData(HomeViewModel.sortByUpdate)
  })

  vm.stateLiveData.observe(viewLifecycleOwner, Observer {
   when(it){
    vm.START->mSwipeRefreshLayout.isRefreshing=true
    vm.END->mSwipeRefreshLayout.isRefreshing=false
   }
  })

  vm.liveData.observe(viewLifecycleOwner, Observer {
   if (it.size>0){
    val homeAdapter = HomeAdapter()
    mRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
    mRecyclerView.adapter = homeAdapter
    homeAdapter.addData(it)
   }
  })

 }

 private fun inReposData(sort: String) {
  var user : String by SharedPref<String>(requireActivity(), SharedPrefCont.USER_ACCOUNT, "")
  vm.getRepos(user/*"SoarY"*/, 1, 30, sort)
 }

 private fun onMenuSelected(menuItem: MenuItem) {
  inReposData(
   when (menuItem.itemId) {
    R.id.menu_repos_letter -> HomeViewModel.sortByLetter
    R.id.menu_repos_update -> HomeViewModel.sortByUpdate
    R.id.menu_repos_created -> HomeViewModel.sortByCreated
    else -> throw IllegalArgumentException("failure menuItem id.")
   }
  )
 }
}