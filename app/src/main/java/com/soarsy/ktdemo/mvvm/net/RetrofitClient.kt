package com.soarsy.ktdemo.mvvm.net

import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * NAME：YONG_
 * Created at: 2022/2/14 16
 * Describe:
 */
class RetrofitClient private constructor(){
 companion object{
  val instance:RetrofitClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { RetrofitClient() }
 }

 private var apis=HashMap<String, API>()

 fun getApi():API?=getApi(APIMain.API_GITHUB)

 fun getApi(host:String):API?{
  if (!apis.containsKey(host)){
   val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .baseUrl(host)
    .build()
   val api = retrofit.create(API::class.java)
   apis[host] = api
  }
  return apis[host]
 }
}