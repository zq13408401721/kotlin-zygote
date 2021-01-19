package com.baseclient.ui

import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.baseclient.BR
import com.baseclient.R
import com.baseclient.databinding.ActivityHomeBinding
import com.baseclient.ui.adapter.BrandAdapter
import com.baseclient.viewmodel.home.HomeViewModel
import com.shop.base.BaseActivity
import com.shop.base.IItemClick
import com.shop.model.HomeData

class HomeActivity:BaseActivity<HomeViewModel,ActivityHomeBinding>(R.layout.activity_home,HomeViewModel::class.java) {

    var brandList:MutableList<HomeData.Brand> = mutableListOf()
    lateinit var brandAdapter:BrandAdapter


    /**
     * 初始化界面
     */
    override fun initView() {
        var arr = SparseArray<Int>()
        //通过布局id关联绑定数据的id 用于解决多布局的数据绑定的问题
        arr.put(R.layout.layout_brand_item,BR.vmBrand)
        brandAdapter = BrandAdapter(this,brandList,arr,BrandItemClick())
        mDataBinding.recyBrand.layoutManager = GridLayoutManager(this,2)
        mDataBinding.recyBrand.adapter = brandAdapter
    }

    /**
     * 初始化ViewModel
     */
    override fun initVM() {
        /**
         * 监听数据加载返回的监听
         */
        mViewModel.homeData.observe(this, Observer {
            updateBrand(it.brandList)
        })
    }

    /**
     * 初始化加载数据
     */
    override fun initData() {
        mViewModel.loadHomeData()
    }

    /**
     * 初始化界面绑定的绑定数据
     */
    override fun initVariable() {
        mDataBinding.setVariable(BR.homeClick,TitleClick())
    }

    /**
     * 刷新brand数据
     */
    private fun updateBrand(list:List<HomeData.Brand>){
        brandList.clear()
        brandList.addAll(list)
        brandAdapter.notifyDataSetChanged()
    }

    /**
     * 界面的点击事件 用于绑定点击事件的操作
     */
    inner class TitleClick{

        fun clickBrand(){

        }

        fun clickNewGood(){

        }

        fun clickHotGood(){

        }

        fun clickTopic(){

        }
    }

    /**
     * brandItem条目点击事件
     */
    inner class BrandItemClick:IItemClick<HomeData.Brand>{
        override fun itemClick(data: HomeData.Brand) {

        }

    }
}