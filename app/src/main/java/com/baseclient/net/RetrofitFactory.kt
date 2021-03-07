package com.shop.net

import android.util.Log
import com.baseclient.base.BaseApi
import com.shop.app.Constants
import com.shop.utils.MyMmkv
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory {

    /**
     * 伴生对象 单例
     */
    companion object{
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val interceptor: Interceptor
    private val retrofit: Retrofit

    //初始化
    init {
        //通用拦截
        interceptor = Interceptor {
            chain -> val request = chain.request()
                .newBuilder()
                .addHeader("charset","UTF-8")
                .addHeader(MyMmkv.getString(Constants.token_key),MyMmkv.getString(Constants.token))
                .build()
            chain.proceed(request)
        }

        //Retrofit实例化
        retrofit = Retrofit.Builder()
                .baseUrl(BaseApi.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    /*
        OKHttp创建
     */
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(MoreBaseUrlInterceptor())
                .addInterceptor(LoggingInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    /*
        日志拦截器
     */
    class LoggingInterceptor:Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            var response = chain.proceed(request)
            var responseBody = response.peekBody(Long.MAX_VALUE)
            Log.i("responseBody",responseBody.string())
            return response
        }
    }

    /**
     * 基础地址
     */
    class MoreBaseUrlInterceptor:Interceptor{

        override fun intercept(chain: Interceptor.Chain): Response {
            var req = chain.request()
            var oldUrl = req.url()
            //builder
            var builder = req.newBuilder()
            var newUrl = req.header("newurl")
            if(newUrl != null && newUrl!!.isNotEmpty()){
                var baseUrl = HttpUrl.parse(newUrl)
                var newHttpUrl = HttpUrl.Builder()
                        .scheme(baseUrl!!.scheme())
                        .host(baseUrl!!.host())
                        .port(baseUrl!!.port())
                        .encodedPath(oldUrl.encodedPath())
                        .encodedQuery(oldUrl.encodedQuery())
                        .build()
                var newReq = builder.url(newHttpUrl).build()
                return chain.proceed(newReq)
            }
            return chain.proceed(req)
        }
    }

    /*
        具体服务实例化
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }


}