package com.soarsy.ktdemo.mvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * NAME：YONG_
 * Created at: 2022/2/14 11
 * Describe:
 */
abstract class BaseFragment: Fragment() {

 abstract val layoutId:Int

 override fun onCreateView(
  inflater: LayoutInflater,
  container: ViewGroup?,
  savedInstanceState: Bundle?
 ): View? {
  return inflater.inflate(layoutId, container, false)
 }

}