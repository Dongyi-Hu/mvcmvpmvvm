package com.swpuiot.framemodel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.swpuiot.framemodel.controller.MvcActivity

class MainActivity : AppCompatActivity() {

    /** MVC示例按钮 */
    private var btnMVC: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnMVC?.setOnClickListener {
            startActivity(Intent(this, MvcActivity::class.java))
        }
    }

    /**
     * 初始化控件
     */
    private fun initView() {
        btnMVC = findViewById(R.id.btn_mvc)
    }
}