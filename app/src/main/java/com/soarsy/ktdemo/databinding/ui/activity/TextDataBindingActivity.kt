package com.soarsy.ktdemo.databinding.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.soarsy.ktdemo.R
import com.soarsy.ktdemo.databinding.ActivityTextDbingBinding
import com.soarsy.ktdemo.databinding.vm.TextDataBindingViewModel

/**
 * NAME：YONG_
 * Created at: 2022/2/16 22
 * Describe:
 */
class TextDataBindingActivity:AppCompatActivity() {

    private lateinit var binding: ActivityTextDbingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_text_dbing)
        binding.lifecycleOwner=this

        val vm = ViewModelProvider(this).get(TextDataBindingViewModel::class.java)
        binding.vm=vm
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }


    companion object {
        fun actionStart(context: Context){
            context.startActivity(Intent(context, TextDataBindingActivity::class.java))
        }
    }
}