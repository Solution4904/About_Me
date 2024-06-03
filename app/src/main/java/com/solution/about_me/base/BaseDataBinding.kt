package com.solution.about_me.base

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDataBinding<B : ViewDataBinding>(@LayoutRes val layoutId: Int) : BaseActivity(layoutId) {
    lateinit var binding: B

    override fun init() {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}