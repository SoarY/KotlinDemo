package com.soarsy.ktdemo.Chapter7

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.soarsy.ktdemo.Chapter6.Learn6Activity
import com.soarsy.ktdemo.R
import org.greenrobot.eventbus.EventBus

class Learn7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn7)

        titleView()

        /**
         * 使用Kotlin版本的EventBus，更方便的实现UI间通信，高性能、简单而强大，最主要是使用框架更为便捷；
         * 举个栗子：
         * 比如界面A->界面B 我们可以使用Intent传递
         * 界面B->界面A 我们也可以使用onActivityResult接收
         * 那如果界面A->界面B->界面C，或者界面C->界面A 再使用Intent传递就太绕了
         */
        val butTip1: Button = findViewById(R.id.but_tip1)
        butTip1.setOnClickListener {
            EventBus.getDefault().post("message")
        }

        val butTip2: Button = findViewById(R.id.but_tip2)
        butTip2.setOnClickListener {
            EventBus.getDefault().post(MessageEvent(MessageEvent.MessageType.ShowLog,"打印日志"))
            EventBus.getDefault().post(MessageEvent(MessageEvent.MessageType.ShowToast,"组件间通信"))
        }
    }

    private fun titleView() {
        findViewById<View>(R.id.lly_back).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.tv_title).text="组件间通信"
    }

    companion object {
        fun actionStart(context: Context){
            context.startActivity(Intent(context, Learn7Activity::class.java))
        }
    }
}