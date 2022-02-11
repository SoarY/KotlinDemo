package com.soarsy.ktdemo.Chapter6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.soarsy.ktdemo.Chapter5.Learn5Activity
import com.soarsy.ktdemo.R

class Learn6Activity : AppCompatActivity() {

    private lateinit var editCont:EditText
    private lateinit var butSave: AppCompatButton
    private lateinit var butRead: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn6)

        titleView()

        /*Android系统中主要提供了3种方式用于简单地实现数据持久化功能：
            文件存储、SharedPreferences存储以及数据库存储。*/

        //1、文件储存，onDestroy方法中调用存储，存储到应用内不需要申请权限；
        editCont = findViewById(R.id.edit_cont)
        val fileCont = FileUtils.readerFile(this, fileName)
        if (fileCont.isNotEmpty()){
            editCont.setText(fileCont)
            editCont.setSelection(fileCont.length)
        }

        //2、sharedPreferences存储
        butSave = findViewById(R.id.but_save)
        butSave.setOnClickListener {
            //第一个参数是文件名
            //第二个参数默认的MODE_PRIVATE这一种模式可选，可为0
            val editor = getSharedPreferences(fileName, Context.MODE_PRIVATE).edit()
            editor.putString("account", "PeaceJay")
            editor.putInt("passWord", 123456)
            editor.putBoolean("remember", false)
            editor.apply()
        }

        //读取文件
        butRead = findViewById(R.id.but_read)
        butRead.setOnClickListener {
            val editor = getSharedPreferences(fileName, Context.MODE_PRIVATE)
            val userName = editor.getString("account", "")
            val userAge = editor.getInt("passWord", 0)
            val toast = "account= $userName   passWord= $userAge"
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
        }
    }

    private fun titleView() {
        findViewById<View>(R.id.lly_back).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.tv_title).text="数据存储"
    }

    override fun onDestroy() {
        super.onDestroy()
        //页面关闭储存文件
        FileUtils.saveFile(this, fileName, editCont.text.toString())
    }

    companion object {

        private const val fileName = "strData"//文件名

        fun actionStart(context: Context){
            context.startActivity(Intent(context, Learn6Activity::class.java))
        }
    }
}