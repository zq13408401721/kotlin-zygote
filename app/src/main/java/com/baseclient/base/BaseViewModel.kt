package com.shop.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shop.app.Constants
import com.shop.net.repository.SystemRepository
import com.shop.utils.MyMmkv
import kotlinx.coroutines.launch

open class BaseViewModel(val repository: SystemRepository):ViewModel() {

    /**
     * 定义一个网络请求状态的处理
     */
    protected var status:MutableLiveData<String> = MutableLiveData()

    /**
     * token刷新通知界面的数据状态
     */
    var refreshToken:MutableLiveData<Int> = MutableLiveData()

    /**
     * 刷新token
     */
    protected fun refreshToken(){
        viewModelScope.launch {
            var result = repository.refreshToken()

            when(result.errno){
                0 -> {
                    MyMmkv.setValue(Constants.token,result.data)
                    refreshToken.postValue(1)
                }
                665 -> {
                    refreshToken.postValue(2)
                }

            }
        }
    }

}