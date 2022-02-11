package com.soarsy.ktdemo.Chapter4

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.lang.IllegalArgumentException

/**
 * NAME：YONG_
 * Created at: 2022/2/11 14
 * Describe:
 */
class MyAdapter(fm: FragmentManager,private var totalTabs: Int):FragmentPagerAdapter(fm) {

 override fun getCount(): Int {
  return totalTabs
 }

 override fun getItem(position: Int): Fragment {
  return when(position){
   0->HomeFragment()
   1->NewsFragment()
   2->MineFragment()
   else->throw IllegalArgumentException()
  }
 }
}