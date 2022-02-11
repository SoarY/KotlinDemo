package com.soarsy.ktdemo.Chapter2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soarsy.ktdemo.R

/**
 * NAME：YONG_
 * Created at: 2022/2/10 15
 * Describe:
 */
class Learn2Activity:AppCompatActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_learn2)

  useView()
 }

 private fun useView() {
  val butToast = findViewById<Button>(R.id.but_toast)
  val butIntent = findViewById<Button>(R.id.but_intent)
  val butFinish = findViewById<Button>(R.id.but_finish)
  val butAllFinish = findViewById<Button>(R.id.but_all_finish)
  val butStart = findViewById<Button>(R.id.but_start)

  butToast.setOnClickListener {
   Toast.makeText(this,"Toast提示语",Toast.LENGTH_LONG).show()
  }

  butIntent.setOnClickListener {
   val intent = Intent(Intent.ACTION_VIEW)
   intent.data= Uri.parse("https://blog.csdn.net/qq_30998053/category_11436257.html")
   startActivity(intent)
  }

  butFinish.setOnClickListener {
   val intent = Intent()
   intent.putExtra("data_return", "这是9527返回值")
   setResult(RESULT_OK, intent)
   finish()
  }

  butAllFinish.setOnClickListener {
   Toast.makeText(this,"暂无实现",Toast.LENGTH_LONG).show()
  }

  //4、启动activity的最佳写法
  //比如Learn2Activity并不是由你开发的，但现在你负责开发的部分需要启动Learn2Activity，
  //而你却不清楚启动Learn2Activity需要传递哪些数据
  //在这里我们使用了一个新的语法结构companion object，并在companion object中定义了一个actionStart()方法。
  //之所以要这样写，是因为Kotlin规定，所有定义在companion object中的方法都可以使用类似于Java静态方法的形式调用。
  //养成一个良好的习惯，给你编写的每个Activity都添加类似的启动方法，
  //这样不仅可以让启动Activity变得非常简单，还可以节省不少阅读代码时间
  butStart.setOnClickListener {
   actionStart(this,"data1","data2")
  }
 }

 //修改Learn2Activity启动代码
 companion object {
  fun actionStart(context: Context,data1: String,data2: String){
   context.startActivity(Intent(context,Learn2Activity::class.java).putExtra("data1",data1).putExtra("data2",data2))
  }
 }
}