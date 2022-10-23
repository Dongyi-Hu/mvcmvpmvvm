package com.swpuiot.framemodel.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.swpuiot.framemodel.R
import com.swpuiot.framemodel.model.Account
import com.swpuiot.framemodel.presenter.MVPPresenter

class MvpActivity : AppCompatActivity(), IView, View.OnClickListener {

    private var etAccount: EditText? = null
    private var btnSearch: Button? = null
    private var tvResult: TextView? = null

    /** Activity持有Presenter的引用 */
    private var mvpPresenter = MVPPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        initView()
    }

    private fun initView() {
        etAccount = findViewById(R.id.et_input)
        btnSearch = findViewById(R.id.btn_search)
        btnSearch?.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_search -> {
                val name = getUserInput()
                mvpPresenter.getData(name)
            }
        }
    }

    override fun getUserInput() = etAccount?.text.toString()

    override fun showSuccessPage(account: Account) {
        tvResult?.text = "账号${account.name}的等级为${account.level}"
    }

    override fun showFailedPage() {
        tvResult?.text = "获取数据失败"
    }
}