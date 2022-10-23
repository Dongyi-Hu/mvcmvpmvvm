package com.swpuiot.framemodel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.swpuiot.framemodel.R
import com.swpuiot.framemodel.databinding.ActivityMvvmBinding
import com.swpuiot.framemodel.viewmodel.ViewModel

class MvvmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mvvm)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)
        viewModel = ViewModel(application, binding)
        binding.viewModel = viewModel
    }

}