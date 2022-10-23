package com.swpuiot.framemodel.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.swpuiot.framemodel.BR
import com.swpuiot.framemodel.MCallback
import com.swpuiot.framemodel.databinding.ActivityMvvmBinding
import com.swpuiot.framemodel.model.Account

/**
 * Author: Nicole
 * Time: 2022/10/23
 * Description:
 */
class ViewModel : BaseObservable {
    @get:Bindable
    var result: String? = null
        set(result) {
            field = result
            notifyPropertyChanged(BR.result)
        }
    private var model: Account
    private var binding: ActivityMvvmBinding? = null

    constructor(application: Application?) {
        model = Account("hudongyi", 100)
    }

    constructor(application: Application?, binding: ActivityMvvmBinding?) {
        model = Account("hudongyi", 100)
        this.binding = binding
    }

    fun getData(view: View) {
            val name = binding!!.etInput.text.toString()
            model.getAccountData(name, object : MCallback {
                override fun onSuccess(account: Account) {
                    val info = "账号：" + account.name + "的等级为：" + account.level
                    result = info
                }

                override fun onFailed() {
                    result = "获取数据失败"
                }
            })
        }
}