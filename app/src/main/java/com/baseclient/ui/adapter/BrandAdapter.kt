package com.baseclient.ui.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.baseclient.R
import com.shop.base.BaseAdapter
import com.shop.base.IItemClick
import com.shop.model.HomeData

class BrandAdapter(
    context: Context,
    list:List<HomeData.Brand>,
    layouts:SparseArray<Int>,
    click: IItemClick<HomeData.Brand>
):BaseAdapter<HomeData.Brand>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.layout_brand_item
    }

    /**
     * 用于动态刷新数据
     */
    override fun bindData(binding: ViewDataBinding, data: HomeData.Brand, layId: Int) {
    }
}