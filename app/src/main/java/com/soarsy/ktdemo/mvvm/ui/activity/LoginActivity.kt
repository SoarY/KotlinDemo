package com.soarsy.ktdemo.mvvm.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soarsy.ktdemo.R
import com.soarsy.ktdemo.mvvm.ui.fragment.LoginsFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.apply {
            findFragmentByTag(TAG)?:beginTransaction()
                .add(R.id.summaryCont, LoginsFragment(), TAG)
                .commitAllowingStateLoss()
        }

    }

    companion object {

        private const val TAG = "LoginsFragment"

        fun actionStart(context: Context){
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}