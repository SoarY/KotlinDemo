package com.soarsy.ktdemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.soarsy.ktdemo.Chapter2.Learn2Activity
import com.soarsy.ktdemo.Chapter3.Learn3Activity
import com.soarsy.ktdemo.Chapter4.Learn4Activity
import com.soarsy.ktdemo.Chapter5.Learn5Activity
import com.soarsy.ktdemo.Chapter6.Learn6Activity
import com.soarsy.ktdemo.Chapter7.Learn7Activity
import com.soarsy.ktdemo.Chapter7.MessageEvent
import com.soarsy.ktdemo.databinding.ui.activity.TextDataBindingActivity
import com.soarsy.ktdemo.mvvm.ui.activity.LoginActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    private lateinit var button7:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //注册，重复注册会导致崩溃
        EventBus.getDefault().register(this)

        chapter2()

        chapter3()

        chapter4()

        chapter5()

        chapter6()

        chapter7()

        chapter8()

        chapter9()
    }

    private fun chapter2() {
        val chapter2 = findViewById<View>(R.id.chapter2)
        chapter2.setOnClickListener {
            val intent=Intent(this, Learn2Activity::class.java)
            intent.putExtra("dataName", "chapter2")
            startActivityForResult(intent,927)
        }
    }

    private fun chapter3() {
        val button: Button = findViewById(R.id.chapter3)
        button.setOnClickListener {
            Learn3Activity.actionStart(this)
        }
    }

    private fun chapter4() {
        val button: Button = findViewById(R.id.chapter4)
        button.setOnClickListener {
            Learn4Activity.actionStart(this)
        }
    }

    private fun chapter5() {
        val button: Button = findViewById(R.id.chapter5)
        button.setOnClickListener {
            Learn5Activity.actionStart(this)
        }
    }

    private fun chapter6() {
        val button: Button = findViewById(R.id.chapter6)
        button.setOnClickListener {
            Learn6Activity.actionStart(this)
        }
    }

    private fun chapter7() {
        button7 = findViewById(R.id.chapter7)
        button7.setOnClickListener {
            Learn7Activity.actionStart(this)
        }
    }

    private fun chapter8() {
        val button8 = findViewById<View>(R.id.chapter8)
        button8.setOnClickListener {
            LoginActivity.actionStart(this)
        }
    }

    private fun chapter9() {
        val button9 = findViewById<View>(R.id.chapter9)
        button9.setOnClickListener {
            TextDataBindingActivity.actionStart(this)
        }
    }

    //接收消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: String) {
        if (event == "message") {
            Toast.makeText(this, "收到订阅，主界面已更新", Toast.LENGTH_SHORT).show()
            button7.text = "①主界面更新"
        }
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        when(event.type){
            MessageEvent.MessageType.ShowLog->{
                Log.e("tag", "onMessageEvent: " + event.string)
            }
            MessageEvent.MessageType.ShowToast->{
                Toast.makeText(this, "onMessageEvent: " + event.string, Toast.LENGTH_SHORT).show()
                button7.text = "②" + event.string
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}