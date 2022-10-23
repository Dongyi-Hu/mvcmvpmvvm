package com.swpuiot.framemodel.model

import com.swpuiot.framemodel.MCallback
import kotlin.random.Random

/**
 * Author: Nicole
 * Time: 2022/10/22
 * Description:
 */
data class Account(var name: String = "", var level: Int = 0) {

     fun getUserAccount(name: String, callback: MCallback) {
        val isSuccess = Random.nextBoolean()
        if (isSuccess) {
            callback.onSuccess(Account(name, 100))
        } else {
            callback.onFailed()
        }
    }
}
