package com.soarsy.ktdemo.Chapter5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * NAME：YONG_
 * Created at: 2022/2/11 16
 * Describe:
 */
class MyReceiver:BroadcastReceiver() {
 override fun onReceive(context: Context, intent: Intent?) {
  Toast.makeText(context, "开机广播", Toast.LENGTH_SHORT).show()
  //接收到广播打开当前程序
  context.startActivity(context.packageManager.getLaunchIntentForPackage(context.packageName))
 }
}