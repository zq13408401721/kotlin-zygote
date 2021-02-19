package com.shop.utils

import com.baseclient.app.BaseApp
import com.tencent.mmkv.MMKV

/**
 * 本地数据保存MMKV替换掉sp
 *
 */
class MyMmkv {

    /**
     * 伴生对象 static
     */
    companion object{

        private lateinit var mkv:MMKV

        /**
         * 初始化MMKV
         */
        fun initMMKV(){
            MMKV.initialize(BaseApp.instance)
            mkv = MMKV.defaultMMKV()
        }

        //保存数据
        fun setValue(key:String,value:Any){
            if(value is String){
                mkv.putString(key,value as String)
            }else if(value is Int){
                mkv.putInt(key,value as Int)
            }else if(value is Boolean){
                mkv.putBoolean(key,value as Boolean)
            }else if(value is Float){
                mkv.putFloat(key,value as Float)
            }else if(value is Long){
                mkv.putLong(key,value as Long)
            }else if(value is ByteArray){
                mkv.putBytes(key,value as ByteArray)
            }
        }
        //获取数据
        fun getString(key:String): String? {
            return mkv.getString(key,"")
        }

        fun getInt(key:String):Int{
            return mkv.getInt(key,0)
        }

        fun getBool(key:String):Boolean{
            return mkv.getBoolean(key,false)
        }

        fun getFloat(key:String):Float{
            return mkv.getFloat(key,0f)
        }

        fun getLong(key:String):Long{
            return mkv.getLong(key,0)
        }

        fun getBts(key: String):ByteArray{
            return mkv.getBytes(key,null)
        }
    }

}