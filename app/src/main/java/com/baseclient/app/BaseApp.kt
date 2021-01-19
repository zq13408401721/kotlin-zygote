package com.baseclient.app

import android.app.Application
import com.shop.utils.MyMmkv

open class BaseApp:Application() {

    companion object{
        var instance:BaseApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        MyMmkv.initMMKV()
    }

}