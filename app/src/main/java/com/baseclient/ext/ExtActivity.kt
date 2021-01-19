package com.shop.ext

import android.app.Activity
import android.view.View

/**
 * 扩展Activity的界面组件获取
 */
fun <V:View> Activity.findView(id:Int):Lazy<V> = lazy {
    viewFinder(id) as V
}

//acitivity中扩展调用
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }
