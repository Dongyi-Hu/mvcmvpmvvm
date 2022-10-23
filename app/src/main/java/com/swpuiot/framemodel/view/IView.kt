package com.swpuiot.framemodel.view

import com.swpuiot.framemodel.model.Account

/**
 * Author: Nicole
 * Time: 2022/10/22
 * Description: View顶层接口
 */
interface IView {
    fun getUserInput() : String
    fun showSuccessPage(account: Account)
    fun showFailedPage()
}