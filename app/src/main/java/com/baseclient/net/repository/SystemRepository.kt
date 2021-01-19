package com.shop.net.repository

import com.baseclient.base.BaseRepository
import com.shop.api.ServiceApi
import com.shop.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api   类似mvp的m层逻辑
 */
class SystemRepository:BaseRepository<ServiceApi>(ServiceApi::class.java) {

    /**
     * 刷新token
     */
    suspend fun refreshToken() = withContext(Dispatchers.IO){
        api.refreshToken()
    }


    /**
     * 获取主页数据
     */
    suspend fun getHome() = withContext(Dispatchers.IO){
        api.getHome()
    }

    /**
     * 获取专题数据
     */
    suspend fun getTopic(page:Int,size:Int) = withContext(Dispatchers.IO){
        api.getTopic(page,size)
    }


}