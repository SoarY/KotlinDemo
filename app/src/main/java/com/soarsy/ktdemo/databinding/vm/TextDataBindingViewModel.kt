package com.soarsy.ktdemo.databinding.vm

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * NAME：YONG_
 * Created at: 2022/2/16 23
 * Describe:
 */
class TextDataBindingViewModel:ViewModel() {

 val liveData = MutableLiveData<String>()

 init {
     liveData.postValue("init text")
 }

    val onClickListener= View.OnClickListener {
        liveData.postValue("onClick text")
    }

}