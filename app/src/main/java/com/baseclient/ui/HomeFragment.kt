package com.baseclient.ui

import com.baseclient.R
import com.baseclient.databinding.FragmentHomeBinding
import com.baseclient.viewmodel.home.HomeViewModel
import com.shop.base.BaseFragment
import com.shop.net.repository.SystemRepository

class HomeFragment:BaseFragment<HomeViewModel,FragmentHomeBinding>(R.layout.fragment_home,HomeViewModel::class.java) {
    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initVM() {

    }

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun initVariable() {
        TODO("Not yet implemented")
    }
}