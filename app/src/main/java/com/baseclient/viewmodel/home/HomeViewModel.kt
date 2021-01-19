package com.baseclient.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.model.HomeData
import com.baseclient.net.repository.MyInjection
import com.shop.net.repository.SystemRepository
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel<SystemRepository>(MyInjection.repository) {

    var homeData:MutableLiveData<HomeData> = MutableLiveData()

    /**
     * 加载首页数据
     */
    fun loadHomeData(){
        viewModelScope.launch {
            var result = repository.getHome()
            homeData.postValue(result.data)
        }
    }

}