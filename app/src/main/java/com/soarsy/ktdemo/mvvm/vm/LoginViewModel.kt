package com.soarsy.ktdemo.mvvm.vm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.soarsy.ktdemo.mvvm.bean.UserInfo
import com.soarsy.ktdemo.mvvm.net.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * NAME：YONG_
 * Created at: 2022/2/14 14
 * Describe:
 */
class LoginViewModel:BaseViewModel() {
    val liveData =MutableLiveData<UserInfo>()

    @SuppressLint("CheckResult")
    fun getLogin(auth:String){
        RetrofitClient.instance.getApi()!!
            .getLogin(auth)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveData.postValue(it)
            }, {
                Log.i("TEST_TAG", "getLogin: "+it.message)
            })
    }
}