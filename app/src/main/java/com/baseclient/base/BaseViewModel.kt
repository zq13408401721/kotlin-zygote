package com.shop.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 抽取ViewModel的基类，实现与数据仓库的绑定
 * R为子类中的仓库类型
 */
open class BaseViewModel<R>(val repository:R):ViewModel() {


    /**
     * 定义一个网络请求状态的处理
     */
    protected var status:MutableLiveData<String> = MutableLiveData()


}