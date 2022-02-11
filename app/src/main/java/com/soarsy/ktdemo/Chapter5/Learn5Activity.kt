package com.soarsy.ktdemo.Chapter5

import android.content.*
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.soarsy.ktdemo.Chapter4.Learn4Activity
import com.soarsy.ktdemo.R
import kotlin.system.exitProcess

/**
 * Description: 第五天、广播BroadcastReceiver
 * 知识点1：静态注册广播
 * 知识点2：动态注册广播
 * 知识点3：自定义全局广播
 */
class Learn5Activity : AppCompatActivity() {

    private lateinit var time:TimeReceiver
    private lateinit var netWork:NetworkReceiver
    private lateinit var textReceiver:TextReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn5)

        useView()

        /*在代码中注册为动态注册,在AndroidManifest.xml中注册为静态注册*/

        //1、动态注册广播 onResume中

        //2、静态注册广播 AndroidManifest中引用MyReceiver

        //3、自定义一条广播,推送一条消息
    }

    override fun onResume() {
        super.onResume()
        // 监听时间变化,通常一分钟跳一次时间
        time = TimeReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(time,intentFilter)

        // 监听网络变化
        netWork = NetworkReceiver()
        val networkFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(netWork, networkFilter)

        //
        textReceiver = TextReceiver()
        registerReceiver(textReceiver, IntentFilter(KOTLIN_DEMO_RECEIVER))
    }

    override fun onPause() {
        super.onPause()
        //页面关闭，停止广播
        unregisterReceiver(time)
        unregisterReceiver(netWork)
        unregisterReceiver(textReceiver)
    }

    private fun useView() {
        findViewById<View>(R.id.lly_back).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.tv_title).text="BroadcastReceiver"

        //3、自定义一条广播,推送一条消息
        findViewById<View>(R.id.but_send).setOnClickListener {
            sendBroadcast(Intent(KOTLIN_DEMO_RECEIVER))
        }
    }

    inner class TimeReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "时间被监听", Toast.LENGTH_SHORT).show()
            Log.i("TAG", "TimeReceiver: 时间被监听")
        }
    }

    inner class NetworkReceiver:BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            Log.i("TAG", "NetworkReceiver: 网络被监听")

            val manager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetworkInfo

            // 判断网络情况
            if (networkInfo != null && networkInfo.isAvailable) {
                // 网络可用时的执行内容
                Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show()
            } else {
                // 网络不可用时的执行内容
                Toast.makeText(context, "network connect fail", Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class TextReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent?) {
            AlertDialog.Builder(context)
                .setTitle("消息提醒")
                .setMessage("这是一条全局广播，点我退出应用")
                .setPositiveButton("确定") { _, _ ->
                    exitProcess(0)
                }
                .setNeutralButton("取消",null)
                .create()
                .show()
        }
    }

    companion object {
        const val KOTLIN_DEMO_RECEIVER="com.example.kotlin_demo.TextReceiver"

        fun actionStart(context: Context){
            context.startActivity(Intent(context, Learn5Activity::class.java))
        }
    }
}