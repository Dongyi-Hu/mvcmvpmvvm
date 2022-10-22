package com.swpuiot.framemodel.none

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.swpuiot.framemodel.Account
import com.swpuiot.framemodel.MCallback
import com.swpuiot.framemodel.R
import java.util.*
import kotlin.random.Random

class NoneActivity : AppCompatActivity() {

    /** 用户输入的查询账号 */
    private var etAccount: EditText? = null
    /** 查询按钮 */
    private var btnSearch: Button? = null
    /** 查询结果展示 */
    private var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_none)

        initView()

        btnSearch?.setOnClickListener {
            val name = getUserInput()
            getAccountData(name, object : MCallback {
                override fun onSuccess(account: Account) {
                    showSuccessPage(account)
                }

                override fun onFailed() {
                    showFailedPage()
                }

            })
        }

    }

    /**
     * 初始化控件
     */
    private fun initView() {
        etAccount = findViewById(R.id.et_account)
        btnSearch = findViewById(R.id.btn_search)
        tvResult = findViewById(R.id.tv_result)
    }

    /**
     * 获取用户输入内容
     */
    private fun getUserInput() = etAccount?.text.toString()

    /**
     * 显示成功画面
     */
    private fun showSuccessPage(account: Account) {
        tvResult?.visibility = View.VISIBLE
        tvResult?.text = "${account.name} | ${account.level}"
    }

    /**
     * 显示失败画面
     */
    private fun showFailedPage() {
        tvResult?.visibility = View.VISIBLE
        tvResult?.text = "获取数据失败"
    }

    /**
     * 通过随机数模拟获取数据
     */
    private fun getAccountData(accountName: String, callback: MCallback) {
        val isSuccess = Random.nextBoolean()
        if (isSuccess) {
            val account = Account(etAccount?.text.toString(), 100)
            callback.onSuccess(account)
        } else {
            callback.onFailed()
        }
    }
}