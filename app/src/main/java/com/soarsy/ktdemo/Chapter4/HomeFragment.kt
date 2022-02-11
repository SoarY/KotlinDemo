package com.soarsy.ktdemo.Chapter4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soarsy.ktdemo.R

/**
 * NAME：YONG_
 * Created at: 2022/2/11 15
 * Describe:
 */
class HomeFragment:Fragment() {

 private val userList=ArrayList<UserBean>()

 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
  val view = inflater.inflate(R.layout.fragment_home, container, false)
  initUser()
  initView(view)
  return view
 }

 private fun initUser() {
  repeat(1) {
   userList.add(UserBean(R.mipmap.image_nv, "迪丽不热", "17321341289"))
   userList.add(UserBean(R.mipmap.image_nan, "杀手不冷", "17377621412"))
   userList.add(UserBean(R.mipmap.image_nv, "赵思露", "19987878221"))
   userList.add(UserBean(R.mipmap.image_nv, "井川里予", "13612344637"))
   userList.add(UserBean(R.mipmap.image_nan, "阿斯顿", "13635465678"))
   userList.add(UserBean(R.mipmap.image_nan, "没啥用科技", "13801940921"))
   userList.add(UserBean(R.mipmap.image_nv, "阿瑟东", "16622348923"))
  }
 }

 private fun initView(view: View) {
  val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

  val userNewAdapter = UserNewAdapter()
  recyclerView.layoutManager=LinearLayoutManager(activity)
  recyclerView.adapter=userNewAdapter

  userNewAdapter.addData(userList)
 }
}