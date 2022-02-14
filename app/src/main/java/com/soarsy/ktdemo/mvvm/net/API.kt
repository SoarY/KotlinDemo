package com.soarsy.ktdemo.mvvm.net

import com.soarsy.ktdemo.mvvm.bean.UserInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * NAME：YONG_
 * Created at: 2022/2/14 16
 * Describe:
 */
interface API {

 @GET("user")
 fun getLogin(@Header("Authorization") authorization:String): Observable<UserInfo>
}