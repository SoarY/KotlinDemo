package com.soarsy.ktdemo.mvvm.net

import com.soarsy.ktdemo.mvvm.bean.Repos
import com.soarsy.ktdemo.mvvm.bean.UserInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * NAME：YONG_
 * Created at: 2022/2/14 16
 * Describe:
 */
interface API {

 @GET("user")
 fun getLogin(@Header("Authorization") authorization:String): Observable<UserInfo>

 @GET("users/{username}/repos?")
 fun queryRepos(@Path("username") username: String,
                @Query("page") pageIndex: Int,
                @Query("per_page") perPage: Int,
                @Query("sort") sort: String): Observable<Repos>
}