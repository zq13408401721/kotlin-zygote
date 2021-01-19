package com.baseclient.model

//data class BaseResp<out T>(val errno:Int,val errmsg:Int,val data:T)

data class BaseResp<T>
constructor(var errno:Int,var errmsg:String,var data:T)
