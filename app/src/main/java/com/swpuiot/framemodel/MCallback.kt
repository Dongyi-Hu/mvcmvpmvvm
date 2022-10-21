package com.swpuiot.framemodel

/**
 * Author: Nicole
 * Time: 2022/10/22
 * Description:
 */
interface MCallback {
    fun onSuccess(account: Account)
    fun onFailed()
}