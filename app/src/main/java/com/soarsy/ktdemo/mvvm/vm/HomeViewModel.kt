package com.soarsy.ktdemo.mvvm.vm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.soarsy.ktdemo.mvvm.bean.Repos
import com.soarsy.ktdemo.mvvm.net.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * NAME：YONG_
 * Created at: 2022/2/15 10
 * Describe:
 */
class HomeViewModel:BaseViewModel() {

    companion object {
        const val sortByCreated: String = "created"
        const val sortByUpdate: String = "updated"
        const val sortByLetter: String = "full_name"
    }

    val liveData: MutableLiveData<Repos> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getRepos(username: String,
                 pageIndex: Int,
                 perPage: Int,
                 sort: String){
        RetrofitClient.instance.getApi()!!
            .queryRepos(username, pageIndex, perPage, sort)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveData.postValue(it)
                end()
            }, {
                Log.i("TEST_TAG", "queryRepos: "+it.message)
                end()
            },{
            },{
                start()
            })
    }
}