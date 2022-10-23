package com.swpuiot.framemodel.presenter

import com.swpuiot.framemodel.MCallback
import com.swpuiot.framemodel.model.Account
import com.swpuiot.framemodel.view.IView

/**
 * Author: Nicole
 * Time: 2022/10/22
 * Description:
 */
class MVPPresenter(view: IView) {

    /** presenter中持有view和model的引用 */
    private var view: IView? = view
    private val model = Account()

    fun getData(name: String) {
        model.getUserAccount(name, object : MCallback{
            override fun onSuccess(account: Account) {
                view?.showSuccessPage(account)
            }

            override fun onFailed() {
                view?.showFailedPage()
            }
        })
    }
}