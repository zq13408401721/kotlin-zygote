package com.baseclient.net.repository

import com.shop.net.repository.SystemRepository

object MyInjection{

    /**
     * 当前的数据仓库
     */
    val repository:SystemRepository by lazy {
        SystemRepository()
    }

}
