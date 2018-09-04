package com.forfuture.zxg.rooban

import android.app.Activity
import android.os.Bundle
import android.support.annotation.LayoutRes
import butterknife.ButterKnife

abstract class BaseActivity:Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.inject(this)
        if(getLayoutId() != 0){
            setContentView(getLayoutId())
        }
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}