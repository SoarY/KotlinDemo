package com.soarsy.ktdemo.Chapter3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soarsy.ktdemo.R

/**
 * NAME：YONG_
 * Created at: 2022/2/10 15
 * Describe:
 */
class Learn3Activity:AppCompatActivity() {

 private val msgList=ArrayList<MsgBean>()

 private lateinit var recyclerView:RecyclerView

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_learn3)

  useView()

  initMsg()

  recyclerNewView()
 }

 private fun useView() {
  findViewById<View>(R.id.lly_back).setOnClickListener {
   finish()
  }

  findViewById<TextView>(R.id.tv_title).text="聊天室"

  recyclerView = findViewById(R.id.recyclerView)
 }

 private fun initMsg() {
  repeat(1) {
   msgList.add(MsgBean("在吗？还记得我吗？",0))
   msgList.add(MsgBean("当然，初中坐我前排的班花，那时候我还扯过你的肩带",1))
   msgList.add(MsgBean("有啥事吗？",1))
   msgList.add(MsgBean("能借我200块钱吗",0))
   msgList.add(MsgBean("其实从初中开始我就一直暗恋你，没好意思跟你说，我们在一起吧",1))
   msgList.add(MsgBean("别吧🤦我们都多久没联系了，都不了解对方，也不太熟悉😳‍",0))
   msgList.add(MsgBean("那你还好意思找我借钱？‍",1))
   msgList.add(MsgBean("？‍",0))
  }
 }

 private fun recyclerNewView() {
  //①标准写法，使用适配器
  recyclerView.layoutManager = LinearLayoutManager(this)
  recyclerView.adapter = MsgAdapter(msgList)
 }

 companion object {
  fun actionStart(context: Context){
   context.startActivity(Intent(context,Learn3Activity::class.java))
  }
 }
}