package com.swpuiot.framemodel.controller

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.swpuiot.framemodel.MCallback
import com.swpuiot.framemodel.R
import com.swpuiot.framemodel.model.Account

class MvcActivity : AppCompatActivity(), View.OnClickListener {

    /** 用户输入的查询账号 */
    private var etAccount: EditText? = null
    private var btnSearch: Button? = null
    private var tvResult: TextView? = null
    private var accountModel: Account? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        initView()
    }

    /**
     * 初始化控件
     */
    private fun initView() {
        etAccount = findViewById(R.id.et_account)
        btnSearch = findViewById(R.id.btn_search)
        btnSearch?.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)
        accountModel = Account(getUserInput(), 100)
    }

    /**
     * 获取用户输入
     */
    private fun getUserInput() = etAccount?.text.toString()

    /**
     * 展示成功页面
     */
    private fun showSuccessPage(account: Account) {
        tvResult?.text = "账号：${account.name}的等级为${account.level}"
    }

    /**
     * 展示失败页面
     */
    private fun showFailedPage() {
        tvResult?.text = "获取数据失败"
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_search -> {
                val name = getUserInput()
                Log.e("TAG", "onClick: name=$name")
                accountModel?.getAccountData(name, object: MCallback{
                    override fun onSuccess(account: Account) {
                        showSuccessPage(account)
                        Log.e("TAG", "onSuccess: ${account.name}")
                    }

                    override fun onFailed() {
                        showFailedPage()
                        Log.e("TAG", "onFailed: ")
                    }
                })
            }
            else -> Toast.makeText(this, "else branch", Toast.LENGTH_SHORT).show()
        }
    }
}