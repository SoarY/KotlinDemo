package com.soarsy.ktdemo.mvvm.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soarsy.ktdemo.R
import com.soarsy.ktdemo.mvvm.ui.fragment.GithubHomeFragment

class GithubHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_home)

        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.apply {
            findFragmentByTag(TAG)?:beginTransaction()
                .add(R.id.summaryCont, GithubHomeFragment(), TAG)
                .commitAllowingStateLoss()
        }
    }

    companion object {
        private val TAG = GithubHomeFragment::class.java.simpleName

        fun actionStart(context: Context){
            context.startActivity(Intent(context, GithubHomeActivity::class.java))
        }
    }
}