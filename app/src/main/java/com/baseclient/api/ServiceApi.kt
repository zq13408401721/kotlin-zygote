package com.shop.api

import com.baseclient.model.BaseResp
import com.shop.model.HomeData
import com.shop.model.TopicData
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 网络请求API
 */
interface ServiceApi {


    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>

    @GET("index")
    suspend fun getHome():BaseResp<HomeData>   // BaseResp抽取的一个bean类的外层结构 homeData当前接口返回的具体

    //专题
    @GET("topic/list")
    suspend fun getTopic(@Query("page") page:Int,@Query("size") size:Int):BaseResp<TopicData>



}