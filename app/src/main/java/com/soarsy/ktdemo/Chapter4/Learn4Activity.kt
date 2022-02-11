package com.soarsy.ktdemo.Chapter4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.soarsy.ktdemo.R

class Learn4Activity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn4)

        useView()
    }

    private fun useView() {
        findViewById<View>(R.id.lly_back).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.tv_title).text="Fragment"

        tabLayout = findViewById(R.id.tab_main)
        viewPager = findViewById(R.id.viewPager)

        //tabLayout!!.addTab(tabLayout!!.newTab().setText("首页"))
        tabLayout.addTab(tabLayout.newTab().setText("首页"))
        tabLayout.addTab(tabLayout.newTab().setText("资讯"))
        tabLayout.addTab(tabLayout.newTab().setText("我的"))

        tabLayout.tabGravity=TabLayout.GRAVITY_FILL

        val myAdapter = MyAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter=myAdapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    companion object {
        fun actionStart(context: Context){
            context.startActivity(Intent(context, Learn4Activity::class.java))
        }
    }
}