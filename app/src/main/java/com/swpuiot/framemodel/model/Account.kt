package com.swpuiot.framemodel.model

import android.util.Log
import com.swpuiot.framemodel.MCallback
import kotlin.random.Random

/**
 * Author: Nicole
 * Time: 2022/10/22
 * Description:Account实体类
 */
data class Account(var name: String = "", var level: Int = 0) {

    /**
     * 模拟数据查询
     */
    fun getAccountData(name: String, callback: MCallback) {
        val isSuccess = Random.nextBoolean()
        Log.e("TAG", "getAccountData: isSuccess:$isSuccess", )
        if (isSuccess) {
            callback.onSuccess(Account(name, 100))
        } else {
            callback.onFailed()
        }
    }
}
