package com.swpuiot.framemodel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.swpuiot.framemodel.view.MvpActivity

class MainActivity : AppCompatActivity() {

    /** mvp按钮 */
    private var btnSearch: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnSearch?.setOnClickListener {
            startActivity(Intent(this, MvpActivity::class.java))
        }
    }

    private fun initView() {
        btnSearch = findViewById(R.id.btn_mvp)
    }
}