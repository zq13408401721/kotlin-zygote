package com.baseclient.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.model.HomeData
import com.shop.net.Injection
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel(Injection.repository) {

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