package com.shop.net.repository

import com.shop.api.ServiceApi
import com.shop.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api   类似mvp的m层逻辑
 */
class SystemRepository {

    private lateinit var serviceApi: ServiceApi

    //初始化的方法
    init {
        serviceApi = RetrofitFactory.instance.create(ServiceApi::class.java)
    }

    /**
     * 刷新token
     */
    suspend fun refreshToken() = withContext(Dispatchers.IO){
        serviceApi.refreshToken()
    }


    /**
     * 获取主页数据
     */
    suspend fun getHome() = withContext(Dispatchers.IO){
        serviceApi.getHome()
    }

    /**
     * 获取专题数据
     */
    suspend fun getTopic(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getTopic(page,size)
    }


}