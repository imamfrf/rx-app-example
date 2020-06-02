package com.imamfrf.rxappexample.utils

import android.content.Context
import android.widget.Toast

object Constants {
    val TAG = "RxExample"

    fun toast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}