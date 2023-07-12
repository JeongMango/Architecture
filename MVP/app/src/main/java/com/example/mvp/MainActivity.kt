package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ViewInterface {
    lateinit var binding: ActivityMainBinding

    var presenter = Presenter(this)
    var model = Model()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this
    }

    fun clickNumber(i: Int) {
        presenter.clickNumber(i)
    }

    override fun ToastMessage(i: Int) {
        Toast.makeText(this, "$i 번을 클릭했습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun checkPasswordMessage() {
        binding.txtMessageSuccess.visibility = View.VISIBLE
    }
}