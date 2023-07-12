package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var viewModel = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, "$it 번을 클릭했습니다.", Toast.LENGTH_SHORT).show()
        })
        viewModel.checkPasswordMessage.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if(viewModel.checkPasswordMessage.get() == true){
                    binding.txtMessageSuccess.visibility = View.VISIBLE
                }else{
                    binding.txtMessageSuccess.visibility = View.GONE
                }
            }

        })

    }

}