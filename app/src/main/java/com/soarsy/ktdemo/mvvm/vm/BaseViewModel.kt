package com.soarsy.ktdemo.mvvm.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * NAME：YONG_
 * Created at: 2022/2/14 14
 * Describe:
 */
open class BaseViewModel:ViewModel() {
    val START = 0
    val END = 1

    val stateLiveData: MutableLiveData<Int> = MutableLiveData()

    fun start() {
        stateLiveData.postValue(START)
    }

    fun end() {
        stateLiveData.postValue(END)
    }
}