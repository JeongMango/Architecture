package com.example.mvp

import android.view.View
import android.widget.Toast

class Presenter(var viewInterface: ViewInterface) {
    var model = Model()

    /*var viewInterface : ViewInterface? = null
    constructor(viewInterface: ViewInterface){
        this.viewInterface = viewInterface
    }*/
    fun clickNumber(i: Int) {
        viewInterface.ToastMessage(i)
        model.inputPassword(i)

        if (model.password.size == 4 && model.checkPassword()) {
            //4자리 이상 비밀번호가 1234
            viewInterface.checkPasswordMessage()
        }
    }
}