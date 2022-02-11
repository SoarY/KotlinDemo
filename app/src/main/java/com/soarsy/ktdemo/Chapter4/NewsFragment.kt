package com.soarsy.ktdemo.Chapter4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soarsy.ktdemo.R

/**
 * NAME：YONG_
 * Created at: 2022/2/11 14
 * Describe:
 */
class NewsFragment:Fragment() {
 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
  return inflater.inflate(R.layout.fragment_news, container, false)
 }
}