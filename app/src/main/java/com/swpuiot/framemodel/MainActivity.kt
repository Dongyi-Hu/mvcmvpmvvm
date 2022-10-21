package com.swpuiot.framemodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.swpuiot.framemodel.none.NoneActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btnNone : Button? = null
    private var btnMVC : Button? = null
    private var btnMVP : Button? = null
    private var btnMVVM : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnNone = findViewById(R.id.btn_none)
        btnNone?.setOnClickListener(this)
        btnMVC = findViewById(R.id.btn_mvc)
        btnMVC?.setOnClickListener(this)
        btnMVP = findViewById(R.id.btn_mvp)
        btnMVP?.setOnClickListener(this)
        btnMVVM = findViewById(R.id.btn_mvvm)
        btnMVVM?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_none -> startActivity(Intent(this, NoneActivity::class.java))
        }
    }
}
