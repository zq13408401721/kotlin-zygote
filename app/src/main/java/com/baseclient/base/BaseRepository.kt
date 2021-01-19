package com.baseclient.base

import com.shop.net.RetrofitFactory

/**
 * 仓库基类 S为仓库对应的接口类
 */
open class BaseRepository<S>(
    cla:Class<S>
) {
    protected var api:S

    //初始化的方法
    init {
        api = RetrofitFactory.instance.create(cla)
    }
}