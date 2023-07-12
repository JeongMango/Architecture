package com.example.mvc

class Model {
    var password: MutableList<Int> = mutableListOf()

    fun inputPassword(i: Int) {
        if (password.size < 4) {
            password.add(i)
        }
    }

    fun checkPassword(): Boolean {
        var trueCount = 0
        var savePassword = mutableListOf<Int>(1, 3, 2, 4)

        for(i in 0 until savePassword.size){
            if(savePassword.get(i) == password.get(i)){
                trueCount++
            }

        }
        return trueCount == 4
    }

}