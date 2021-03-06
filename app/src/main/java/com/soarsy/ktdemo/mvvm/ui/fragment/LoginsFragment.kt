package com.soarsy.ktdemo.mvvm.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soarsy.ktdemo.R
import com.soarsy.ktdemo.mvvm.ui.activity.GithubHomeActivity
import com.soarsy.ktdemo.mvvm.utlis.SharedPref
import com.soarsy.ktdemo.mvvm.utlis.SharedPrefCont
import com.soarsy.ktdemo.mvvm.vm.LoginViewModel

/**
 * NAME：YONG_
 * Created at: 2022/2/14 11
 * Describe:
 */
class LoginsFragment: BaseFragment() {

 private lateinit var tvUsername:EditText
 private lateinit var mBtnSignIn:Button

 private lateinit var vm:LoginViewModel

 override val layoutId: Int= R.layout.fragment_login

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  findView(view)

  binds()
 }

 private fun findView(view:View) {
  tvUsername = view.findViewById(R.id.tvUsername)
  mBtnSignIn = view.findViewById(R.id.mBtnSignIn)
 }

 private fun binds() {
  tvUsername.setText(token)

  vm = ViewModelProvider(this).get(LoginViewModel::class.java)

  vm.liveData.observe(viewLifecycleOwner, Observer {
   var user : String by SharedPref<String>(requireActivity(), SharedPrefCont.USER_ACCOUNT, "")
   user=it.login
   GithubHomeActivity.actionStart(requireActivity())
  })

  mBtnSignIn.setOnClickListener {
   vm.getLogin(token)
   //vm.liveData.postValue(null)
  }
 }

 companion object{
  const val token="token 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"
 }
}