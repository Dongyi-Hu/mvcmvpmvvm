package com.swpuiot.framemodel

import com.swpuiot.framemodel.model.Account

/**
 * Author: Nicole
 * Time: 2022/10/22
 * Description:
 */
interface MCallback {
    fun onSuccess(account: Account)
    fun onFailed()
}