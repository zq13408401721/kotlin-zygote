package com.shop.ext

import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * Adapter条目中imageview图片的加载
 */
class ImageLoader{
    //伴生对象生成单例的操作
    companion object ImageLoader {

        /**
         * 定义adapter中组件的自定义属性
         * requireAll = true 所有属性必须同时使用
         */
        @BindingAdapter(value = ["bind:imgUrl","bind:corner"], requireAll = true)
        @JvmStatic
        fun loadCornerImg(img: ImageView, url: String, corner: Int){
            if(url.isNullOrEmpty()){
                Log.i("TAG","图片路径错误")
                return
            }
            var corNum = if(corner == 0) 1 else corner
            val options = RequestOptions()
            options.transform(CenterCrop(),RoundedCorners(corNum))
            Glide.with(img).load(url).apply(options).into(img)
        }

        /**
         * 普通的加载图片
         */
        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun loadImage(img:ImageView,url:String){
            if(url.isNullOrEmpty()){
                Log.i("TAG","图片路径错误")
                return
            }
            Glide.with(img).load(url).into(img)
        }

    }
}
