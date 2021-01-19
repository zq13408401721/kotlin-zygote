package com.shop.ext

import android.view.View

/**
 * View扩展 FindViewById的操作
 */
fun <V> View.findView(id: Int):Lazy<V> = lazy {
    findViewById(id)
}